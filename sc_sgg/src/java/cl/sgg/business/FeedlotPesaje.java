//v1.0.0
package cl.sgg.business;

import cl.sgg.dao.*;
import cl.sgg.edm.*;
import cl.sgg.utils.BusquedaDIIO;
import cl.sgg.utils.Respuesta;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class FeedlotPesaje 
{
    private List<String> listTipoPesaje;
    private Establecimiento rup;
    private List<Animal> listGrilla;

    public List<String> getListTipoPesaje() {
        return listTipoPesaje;
    }

    public void setListTipoPesaje(List<String> listTipoPesaje) {
        this.listTipoPesaje = listTipoPesaje;
    }

    public Establecimiento getRup() {
        return rup;
    }

    public void setRup(Establecimiento rup) {
        this.rup = rup;
    }

    public List<Animal> getListGrilla() {
        return listGrilla;
    }

    public void setListGrilla(List<Animal> listGrilla) {
        this.listGrilla = listGrilla;
    }
    
    //Constructor por defecto
    public FeedlotPesaje()
    {
        this.listGrilla = new ArrayList<Animal>();
        this.listTipoPesaje = new ArrayList<String>();
        this.rup = new Establecimiento();
    }
    
    // Método público que carga lista de Tipo Pesaje con valores "Pesaje Destete" y "Pesaje Feedlot"
    // ENTRADA: Sin entrada
    // SALIDA: carga en el atributo de la clase "List<String> listTipoPesaje" con el resultado
    public Respuesta CargaCbTipoPesaje() throws Exception
    {
        this.listTipoPesaje.add("Pesaje Destete");
        this.listTipoPesaje.add("Pesaje Feedlot");
        Respuesta r = new Respuesta();
        r.setMensaje("Lista cargada");
        r.setStatus(true);
        return r;
    }
    
    // Método público que invoca la carga de DIIO a pesar
    // ENTRADA: Se ingresa valor de DIIO a pesar
    // ENTRADA: Se ingresa peso animal
    // SALIDA: carga en el atributo de la clase "List<Animal> listGrilla" con el resultado
    public Respuesta CargarDIIOAPesar(int DIIO, float peso) throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            BusquedaDIIO buscaDiio = new BusquedaDIIO();
            Animal animal = buscaDiio.BuscarDIIO(DIIO);
            animal.setAnimalPesoActual(peso);
            if(animal != null)
            {
                if(this.rup.getRupId()==0)
                {
                    EstablecimientoDAO edao = new EstablecimientoDAO();
                    this.rup = edao.getEstablecimientoByRup(animal.getAnimalRupActual());
                    if(this.rup.getRupId() == 0)
                    {
                        this.rup = new Establecimiento();
                        listGrilla.add(animal);
                        r.setMensaje("Error al cargar RUP, no se carga DIIO");
                        r.setStatus(false);
                    }
                }
                else if(animal.getAnimalRupActual()==this.rup.getRupId())
                {
                    listGrilla.add(animal);
                    r.setStatus(true);
                    r.setMensaje("DIIO agregado a grilla");
                }
                else
                {
                    r.setStatus(false);
                    r.setMensaje("DIIO no pertenece al RUP");
                }
            }
            else
            {
                r.setStatus(false);
                r.setMensaje("DIIO no encontrado");
            }
            return r;
        }
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    // Método público que obtiene los datos de Excel y lo traslada a lista de DIIO
    // ENTRADA: FileInputStream objeto que contiene excel con datos a rescatar
    // SALIDA: Carga DIIOS en atributo de clase "listaGrilla"
    public Respuesta CargarDIIOExcel(FileInputStream file) throws Exception
    {
        String cellText;
        try 
        {
            Respuesta r = new Respuesta();
            
            int aux = -1;
            int aux2 = -1;
            //FileInputStream file = new FileInputStream(new File(excelPath));
            //Coge el libro del fichero
            Workbook workbook = new XSSFWorkbook(file);
            
            //Coge la primera hoja del libro
            Sheet sheet = workbook.getSheetAt(0);
            
            //Recorre las filas de la hoja
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()) 
            {
		//Recoge la fila siguiente
                Row row = rowIterator.next();
                
                //Itera por cada celda de cada fila 
                Iterator<Cell> cellIterator = row.cellIterator();
                
		//Recoge la celda actual  
                while(cellIterator.hasNext()) 
                {
                    Cell cell = cellIterator.next();
                    
                    switch(cell.getCellType()) {
                        case Cell.CELL_TYPE_BOOLEAN:
                            cellText = cell.getBooleanCellValue() + "";
                            break;
                        case Cell.CELL_TYPE_NUMERIC:
                            cellText = cell.getNumericCellValue() + "";
                            break;
                        case Cell.CELL_TYPE_STRING:
                            cellText = cell.getStringCellValue();
                            break;
                        case Cell.CELL_TYPE_FORMULA:
                            cellText = cell.getCellFormula();
                            break;
                        default:
                            cellText = cell.getStringCellValue();
                            break;
                    }
                    
                    int DIIO = 0;
                    float peso = 0f;
                    
                    //DIIO
                    if(cellText.equals("DIIO"))
                    {
                        aux = cell.getColumnIndex();
                    }
                    if(aux != -1 && cell.getColumnIndex()==aux)
                    {
                        if(cellText.contains("E"))
                        {
                            
                            int bbb = cellText.indexOf("E");
                            cellText = cellText.substring(0, bbb);
                            
                            cellText = cellText.replace(".", "");
                            System.out.println(cellText);
                            while(cellText.length() < 15)
                            {
                                cellText = cellText+"0";
                            }
                            DIIO = Integer.parseInt(cellText);
                        }
                    }
                    
                    //PESO
                    if(cellText.equals("PESO"))
                    {
                        aux2 = cell.getColumnIndex();
                    }
                    if(aux2 != -1 && cell.getColumnIndex()==aux2)
                    {
                        peso = Float.parseFloat(cellText);
                    } 
                    CargarDIIOAPesar(DIIO, peso);
                }
            }
            r.setMensaje("Formato de Excel no válido");
            r.setStatus(false);
            return r;
        } 
        catch (FileNotFoundException e) 
        {
            throw e;
        } 
        catch (IOException e) 
        {
            throw e;
        }
    }
    
    // Método público guarda registro del formulario
    // ENTRADA: fecha de Manejo
    // ENTRADA: Tipo de pesaje ("Pesaje Destete" o "Pesaje Feedlot")
    // SALIDA: guarda registros de evento y eventoInsumo en la base de datos
    public Respuesta GuardarForm(Date fechaPesaje, String tipoPesaje) throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            r.setMensaje("Se debe agregar un DIIO");
            r.setStatus(false);
            for (Animal arg : this.listGrilla)
            {
                Date d = new Date();
                Evento ev = new Evento();
                ev.setAnimalId(arg.getAnimalId());
                ev.setCategoriaId(arg.getAnimalCategoriaActual());
                ev.setEstadoanimalId(arg.getAnimalEstadoActual());
                ev.setEventoFechaEvento(d);
                ev.setEventoFechaReg(fechaPesaje);
                ev.setEventoValor(0f);
                if(tipoPesaje.equals("Pesaje Destete"))
                {
                    ev.setEventoDs("Pesaje Destete");
                    ev.setEventotipoId(19); //Tipo evento "Pesaje Destete"
                }
                else
                {
                    ev.setEventoDs("Pesaje Feedlot");
                    ev.setEventotipoId(20); //Tipo evento "Pesaje Feedlot"
                }

                EventoDAO edao = new EventoDAO();
                int idEvento = edao.add(ev); //agrega evento a la db
                if (idEvento != 0) 
                {
                    //GUARDAR ANIMAL
                    r.setStatus(true);
                    r.setMensaje("Evento guardado");
                }
                else
                {
                    r.setStatus(false);
                    r.setMensaje("Error en el guardado de evento");
                }
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
}