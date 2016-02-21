//v1.1.0
package cl.sgg.business;

import cl.sgg.dal.Conexion;
import cl.sgg.dao.*;
import cl.sgg.edm.*;
import cl.sgg.utils.BusquedaDIIO;
import cl.sgg.utils.Respuesta;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class FeedlotManejoDestete 
{
    private List<Animal> listAnimal;
    private List<GrillaInsumo> listGrillaInsumo;
    private List<InsumoTipo> listInsumoTipo;
    private List<Insumo> listInsumo;

    public List<Insumo> getListInsumo() {
        return listInsumo;
    }

    public void setListInsumo(List<Insumo> listInsumo) {
        this.listInsumo = listInsumo;
    }
    
    public List<InsumoTipo> getListInsumoTipo() {
        return listInsumoTipo;
    }

    public void setListInsumoTipo(List<InsumoTipo> listInsumoTipo) {
        this.listInsumoTipo = listInsumoTipo;
    }
    
    public List<Animal> getListAnimal() {
        return listAnimal;
    }

    public void setListAnimal(List<Animal> listAnimal) {
        this.listAnimal = listAnimal;
    }

    public List<GrillaInsumo> getListGrillaInsumo() {
        return listGrillaInsumo;
    }

    public void setListGrillaInsumo(List<GrillaInsumo> listGrillaInsumo) {
        this.listGrillaInsumo = listGrillaInsumo;
    }
    
    // Constructor público por defecto
    public FeedlotManejoDestete ()
    {
        this.listAnimal = new ArrayList<Animal>();
        this.listGrillaInsumo = new ArrayList<GrillaInsumo>();
        this.listInsumoTipo = new ArrayList<InsumoTipo>();
        this.listInsumo = new ArrayList<Insumo>();
    }
    
    // Método público que invoca la carga de DIIO a manejar
    // ENTRADA: Se ingresa valor de DIIO a trasladar
    // SALIDA: carga en el atributo de la clase "List<Animal> listAnimal" con el resultado
    public Respuesta CargarDIIOAManejar(int DIIO) throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            BusquedaDIIO buscaDiio = new BusquedaDIIO();
            Animal animal = buscaDiio.BuscarDIIO(DIIO);
            if(animal != null)
            {
                listAnimal.add(animal);
                r.setStatus(true);
                r.setMensaje("DIIO agregado a grilla");
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
    // SALIDA: Carga DIIOS en atributo de clase "listAnimal"
    public Respuesta CargarDIIOExcel(FileInputStream file) throws Exception
    {
        String cellText;
        try 
        {
            Respuesta r = new Respuesta();
            
            int aux = -1;
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
                    return CargarDIIOAManejar(DIIO);
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
    
    // Método público carga lista de tipo Insumo en atributo de la clase
    // ENTRADA: Sin entrada
    // SALIDA: carga en el atributo de la clase "List<InsumoTipo> listInsumoTipo" con el resultado
    public Respuesta CargarTipoInsumo() throws Exception
    {
        Respuesta r = new Respuesta();
        try 
        {
            Statement stmt = Conexion.get().createStatement();
            String query = "SELECT INSUMOTIPO_ID, INSUMOTIPO_DS, INSUMOTIPO_STATUS " +
                "FROM INSUMO_TIPO WHERE INSUMOTIPO_ID <> 4 AND INSUMOTIPO_STATUS = 1";
            ResultSet rs = stmt.executeQuery(query);
     
            this.listInsumoTipo = new ArrayList<InsumoTipo>();
            while (rs.next()) 
            {
                InsumoTipo it = new InsumoTipo();
                it.setInsumotipoDs(rs.getString("INSUMOTIPO_DS"));
                it.setInsumotipoId(rs.getInt("INSUMOTIPO_ID"));
                it.setInsumotipoStatus(rs.getInt("INSUMOTIPO_STATUS"));
                this.listInsumoTipo.add(it);
            }
            
            if(this.listInsumoTipo.size()>0)
            {
                r.setMensaje("Lista Tipo insumo cargada");
                r.setStatus(true);
            }
            else
            {
                r.setMensaje("Lista Tipo insumo no cargada");
                r.setStatus(false);
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    // Método público carga lista de Insumo en atributo de la clase
    // ENTRADA: ID tipo de insumo para filtrar este listado
    // SALIDA: carga en el atributo de la clase "List<Insumo> listInsumo" con el resultado
    public Respuesta CargarInsumo(int INSUMOTIPO_ID) throws Exception
    {
        Respuesta r = new Respuesta();
        try 
        {
            Statement stmt = Conexion.get().createStatement();
            String query = "SELECT INSUMO_ID, TIPOINSUMO_ID, INSUMO_CODIGO_SAP, INSUMO_NOMBRE, INSUMO_DS, "
                    + "INSUMO_UNIDAD_MEDIDA, INSUMO_STATUS, INSUMO_CANTIDAD "
                    + "FROM INSUMO WHERE TIPOINSUMO_ID <> "+INSUMOTIPO_ID+" AND INSUMO_STATUS = 1";
            ResultSet rs = stmt.executeQuery(query);
     
            this.listInsumo = new ArrayList<Insumo>();
            while (rs.next()) 
            {
                Insumo i = new Insumo();
                i.setInsumoCantidad(rs.getInt("INSUMO_CANTIDAD"));
                i.setInsumoCodigoSap(rs.getInt("INSUMO_CODIGO_SAP"));
                i.setInsumoId(rs.getInt("INSUMO_ID"));
                i.setInsumoNombre(rs.getString("INSUMO_NOMBRE"));
                i.setInsumoStatus(rs.getInt("INSUMO_STATUS"));
                i.setInsumoUnidadMedida(rs.getString("INSUMO_UNIDAD_MEDIDA"));
                i.setTipoinsumoId(rs.getInt("TIPOINSUMO_ID"));
                this.listInsumo.add(i);
            }
            
            if(this.listInsumo.size()>0)
            {
                r.setMensaje("Lista Insumo cargada");
                r.setStatus(true);
            }
            else
            {
                r.setMensaje("Lista Insumo no cargada");
                r.setStatus(false);
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    // Método público guarda registro en grilla Insumo
    // ENTRADA: tipo insumo texto
    // ENTRADA: Id Insumo
    // SALIDA: carga en el atributo de la clase "List<Insumo> listInsumo" con el resultado
    public Respuesta GuardarInsumoGrilla(String tipoInsumo, int idInsumo) throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            Insumo i = new Insumo();
            InsumoDAO idao = new InsumoDAO();
            i = idao.getInsumoById(idInsumo);
            if(i != null)
            {
                GrillaInsumo gi = new GrillaInsumo();
                gi.setInsumo(i);
                gi.setTipoInsumo(tipoInsumo);
                this.listGrillaInsumo.add(gi);
                r.setMensaje("dato cargado a grilla");
                r.setStatus(true);
            }
            else
            {
                r.setMensaje("error al cargar Insumo a grilla");
                r.setStatus(false);
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    
    // Método público guarda registro del formulario
    // ENTRADA: fecha de Manejo
    // SALIDA: guarda registros de evento y eventoInsumo en la base de datos
    public Respuesta GuardarForm(Date fechaManejo) throws Exception
    {
        try 
        {
            Respuesta r = new Respuesta();
            r.setMensaje("Se debe agregar un DIIO");
            r.setStatus(false);
            for (Animal arg : listAnimal)
            {
                Date d = new Date();
                Evento ev = new Evento();
                ev.setAnimalId(arg.getAnimalId());
                ev.setCategoriaId(arg.getAnimalCategoriaActual());
                ev.setEstadoanimalId(arg.getAnimalEstadoActual());
                ev.setEventoDs("Manejo destete");
                ev.setEventoFechaEvento(d);
                ev.setEventoFechaReg(fechaManejo);
                ev.setEventoValor(0f);
                ev.setEventotipoId(17); //Tipo evento "Feedlot Destete"

                EventoDAO edao = new EventoDAO();
                int idEvento = edao.add(ev); //agrega evento a la db
                if (idEvento != 0) 
                {
                    int contadorAdd = 0;
                    for(Insumo arg1: listInsumo)
                    {
                        EventoInsumo ei = new EventoInsumo();
                        ei.setEventoId(idEvento);
                        ei.setInsumoId(arg1.getInsumoId());
                        EventoInsumoDAO eidao = new EventoInsumoDAO();
                        int idEventoInsumo = eidao.add(ei);
                        if(idEventoInsumo != 0)
                        {
                            contadorAdd++;
                        }
                        else
                        {
                            r.setStatus(false);
                            r.setMensaje("Error al registrar Evento_Insumo");
                            return r;
                        }
                    }
                    r.setMensaje("Se agrega registro de evento y "+contadorAdd+" Eventos_insumo");
                    r.setStatus(true);
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