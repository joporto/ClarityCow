//v1.3.7
package cl.sgg.business;

// <editor-fold defaultstate="collapsed" desc="Imports">
import cl.sgg.dal.Conexion;
import cl.sgg.dao.*;
import cl.sgg.edm.*;
import cl.sgg.utils.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// </editor-fold>

public class FeedlotTraslado 
{
    // <editor-fold defaultstate="collapsed" desc="Atributos">
    private Animal animal;
    private int idTransporte;
    private FormFeedlotTraslado fft;
    private List<GrillaFeedlotTraslado> listFeedlotTraslado;
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GET & SET">
    public Animal getAnimal()
    {
        return animal;
    }

    public void setAnimal(Animal animal)
    {
        this.animal = animal;
    }
    
    public int getIdTransporte() {
        return idTransporte;
    }

    public void setIdTransporte(int idTransporte) {
        this.idTransporte = idTransporte;
    }

    public FormFeedlotTraslado getFft() {
        return fft;
    }

    public void setFft(FormFeedlotTraslado fft) {
        this.fft = fft;
    }

    public List<GrillaFeedlotTraslado> getListFeedlotTraslado() {
        return listFeedlotTraslado;
    }

    public void setListFeedlotTraslado(List<GrillaFeedlotTraslado> listFeedlotTraslado) {
        this.listFeedlotTraslado = listFeedlotTraslado;
    }
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructores">
    // Constructor público por defecto
    public FeedlotTraslado()
    {
        this.animal = new Animal();
        this.idTransporte = 0;
        this.fft = new FormFeedlotTraslado();
        this.listFeedlotTraslado = new ArrayList<GrillaFeedlotTraslado>();
    }
    
   // Constructor público sobrecargado que agrega valor de idTransporte a atributo clase "int idTransporte"
    public FeedlotTraslado(int idTransporte)
    { 
        this.idTransporte = idTransporte;
        this.fft = new FormFeedlotTraslado();
        this.listFeedlotTraslado = new ArrayList<GrillaFeedlotTraslado>();
    }
    // </editor-fold>
    
    // Método público que carga valores de formulario al cargar pendiente por confirmar de Feedlot
    // ENTRADA: Sin entradas (Usar antes Constructor sobrecargado ya que requiere valor de idTransporte)
    // SALIDA: carga en el atributo de la clase "FormFeedlotTraslado fft" el resultado
    public Respuesta CargarForm() throws Exception //idTransporte recuperado de listado en main Feedlot
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
            Respuesta r = new Respuesta();
            if (this.idTransporte == 0)
            {
                r.setStatus(false);
                r.setMensaje("sin idTransporte");
                return r;
            }

            Statement stmt = Conexion.get().createStatement();
            String query = "select et.EVENTOTIPO_DS, t.TRANSPORTE_FECHA,t.TRANSPORTE_FMA, t.TRANSPORTE_GUIA_DESPACHO, "
                    + "e2.RUP_NOMBRE as RUP_ORIGEN_NOM, e2.RUP_ID as RUP_ORIGEN_ID, "
                    + "e3.RUP_NOMBRE as RUP_DESTINO_NOM, e3.RUP_ID as RUP_DESTINO_ID, e3.RUP_COMUNA, e3.RUP_DIRECCION, "
                    + "tt.TRANSPORTISTA_NRUT, tt.TRANSPORTISTA_DRUT, tt.TRANSPORTISTA_NOMBRE, "
                    + "v.VEHICULO_PATENTE, t.TRANSPORTE_PATENTE_ACOPLADO, "
                    + "e.CATEGORIA_ID, c.CATEGORIA_DS, "
                    + "e.EVENTO_FECHA_REG, e.EVENTO_FECHA_EVENTO "
                    + "from EVENTO e "
                    + "join CATEGORIA c on c.CATEGORIA_ID = e.CATEGORIA_ID "
                    + "join EVENTOTIPO et on et.EVENTOTIPO_ID = e.EVENTOTIPO_ID "
                    + "join EVENTO_TRANSPORTE e1 on e1.EVENTO_ID = e.EVENTO_ID "
                    + "join TRANSPORTE t on t.TRANSPORTE_ID= e1.TRANSPORTE_ID "
                    + "join VEHICULO v on v.VEHICULO_ID = t.VEHICULO_ID "
                    + "join TRANSPORTISTA tt on tt.TRANSPORTISTA_ID = t.TRANSPORTISTA_ID "
                    + "join ESTABLECIMIENTO e2 on e2.RUP_ID= t.TRANSPORTE_RUP_ORIGEN "
                    + "join ESTABLECIMIENTO e3 on e3.RUP_ID= t.TRANSPORTE_RUP_DESTINO "
                    + "where et.EVENTOTIPO_ID = 13 and t.TRANSPORTE_ID = " +this.idTransporte;
       
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) 
            {
                fft = new FormFeedlotTraslado();
                fft.setComuna(rs.getString("RUP_COMUNA"));
                fft.setDireccion(rs.getString("RUP_DIRECCION"));
                fft.setFMA(rs.getString("TRANSPORTE_FMA"));
                fft.setFechaRegistro(rs.getDate("EVENTO_FECHA_REG"));
                fft.setFechaTraslado(rs.getDate("EVENTO_FECHA_EVENTO"));
                fft.setGuiaDespacho(rs.getString("TRANSPORTE_GUIA_DESPACHO"));
                fft.setNomRupDestino(rs.getString("RUP_DESTINO_NOM"));
                fft.setNomRupOrigen(rs.getString("RUP_ORIGEN_NOM"));
                fft.setNomTransportista(rs.getString("TRANSPORTISTA_NOMBRE"));
                fft.setPatenteAcoplado(rs.getString("TRANSPORTE_PATENTE_ACOPLADO"));
                fft.setPatenteVehiculo(rs.getString("VEHICULO_PATENTE"));
                fft.setRupDestino(rs.getInt("RUP_DESTINO_ID")); 
                fft.setRupOrigen(rs.getInt("RUP_ORIGEN_ID"));
                fft.setRutTransportista(rs.getString("TRANSPORTISTA_NRUT")+"-"+rs.getString("TRANSPORTISTA_DRUT"));
                r.setMensaje("OK");
                r.setStatus(true);
                return r;
            }
            r.setMensaje("Sin datos");
            r.setStatus(false);
            return r;
        } 
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            if(!Conexion.get().isClosed())
                Conexion.get().close();
        }
    }
    //</editor-fold>
    
    // Método público que carga valores de grilla DIIOS y status
    // ENTRADA: Sin entradas (Usar antes Constructor sobrecargado ya que requiere valor de idTransporte)
    // SALIDA: carga en el atributo de la clase "List<GrillaFeedlotTraslado> listFeedlotTraslado" el resultado
    public Respuesta CargarGrilla() throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
            Respuesta r = new Respuesta();
            if (this.idTransporte == 0)
            {
                r.setStatus(false);
                r.setMensaje("sin idTransporte");
                return r;
            }
            listFeedlotTraslado = new ArrayList<GrillaFeedlotTraslado>();
            Statement stmt = Conexion.get().createStatement();
            String query = "select a.ANIMAL_DIIO_ACTUAL, a.ANIMAL_PESO_ACTUAL, e.EVENTO_VALOR "
                + "from EVENTO e "
                + "join ANIMAL a on a.ANIMAL_ID = e.ANIMAL_ID "
                + "join EVENTO_TRANSPORTE et on et.EVENTO_ID = e.EVENTO_ID "
                + "join TRANSPORTE t on t.TRANSPORTE_ID = et.TRANSPORTE_ID "
                + "where t.TRANSPORTE_ID = " + this.idTransporte;
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) 
            {
                GrillaFeedlotTraslado gft = new GrillaFeedlotTraslado();
                
                BusquedaDIIO buscaDiio = new BusquedaDIIO();
                Animal animal = buscaDiio.BuscarDIIO(rs.getInt("ANIMAL_DIIO_ACTUAL"));
                if(animal.getAnimalEstadoActual() == 1 || animal.getAnimalEstadoActual() == 2 
                        || animal.getAnimalEstadoActual() == 3 || animal.getAnimalEstadoActual() == 4)
                {
                    gft.setAnimal(animal);
                    gft.setPeso(rs.getFloat("ANIMAL_PESO_ACTUAL"));
                    if(rs.getInt("EVENTO_VALOR")== 0)
                    {
                        gft.setStatus("Por confirmar");
                    }
                    else if (rs.getInt("EVENTO_VALOR")== 1)
                    {
                        gft.setStatus("Confirmado");
                    }
                    this.listFeedlotTraslado.add(gft);
                    r.setMensaje("Datos cargados de grilla");
                    r.setStatus(true);
                }
                else
                {
                    r.setMensaje("DIIO no válido");
                    r.setStatus(false);
                }
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
        finally
        {
            if(!Conexion.get().isClosed())
                Conexion.get().close();
        }
    }
    // </editor-fold>
    
    // Método público que busca Transportista ingresado (búsqueda exacta)
    // ENTRADA: Opcional, Se ingresa valor de rut transportista a consultar sin digito verificador ni puntos, si no va = ""
    // ENTRADA: Opcional, Se ingresa valor de nombre transportista a consultar, si no va = ""
    // SALIDA: carga en el atributo de la clase "FormFeedlotTraslado fft" con el resultado
    public Respuesta BuscarTransportista(String rutTransportista, String nomTransportista) throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
            Respuesta r = new Respuesta();
            TransportistaDAO tdao = new TransportistaDAO();
            Transportista t = new Transportista();
            if (!"".equals(rutTransportista))
            {
                t = tdao.getTransportistaByRut(Integer.parseInt(rutTransportista));
            }
            else if (!"".equals(nomTransportista))
            {
                t = tdao.getTransportistaByNombre(nomTransportista);
            }
            if (t.getTransportistaId() != 0) //encontró transportista?
            {
                if (t.getTransportistaStatus() == 0) //transportista desactivado
                {
                    r.setMensaje("Transportista desactivado");
                    r.setStatus(false);
                    return r;
                }
                else
                {
                    fft.setRutTransportista(t.getTransportistaNrut()+"-"+t.getTransportistaDrut());
                    fft.setNomTransportista(t.getTransportistaNombre());
                    fft.setIdTransportista(t.getTransportistaId());
                    r.setStatus(true);
                    r.setMensaje("Transportista cargado");
                }
            }
            else
            {
                r.setStatus(false);
                r.setMensaje("Transportista no encontrado");
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    //</editor-fold>

    // Método público que busca vehículo ingresado (búsqueda exacta)
    // ENTRADA: Se ingresa valor de patente a consultar
    // SALIDA: carga en el atributo de la clase "FormFeedlotTraslado fft" con el resultado
    public Respuesta BuscarVehiculo(String patente) throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
            Respuesta r = new Respuesta();
            VehiculoDAO vdao = new VehiculoDAO();
            Vehiculo v = new Vehiculo();
            if (!"".equals(patente))
            {
                v = vdao.getVehiculoByPatente(patente);
            }
            
            if (v.getVehiculoId() != 0) //encontró vehiculo?
            {
                if (v.getVehiculoStatus() == 0) //vehiculo desactivado
                {
                    r.setMensaje("Vehículo desactivado");
                    r.setStatus(false);
                    return r;
                }
                else
                {
                    fft.setPatenteVehiculo(v.getVehiculoPatente());
                    fft.setIdVehiculo(v.getVehiculoId());          
                    r.setStatus(true);
                    r.setMensaje("Vehículo cargado");
                }
            }
            else
            {
                r.setStatus(false);
                r.setMensaje("Vehículo no encontrado");
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    //</editor-fold>
    
    // Método público que invoca la busqueda de RUP Origen ingresado (búsqueda exacta)
    // ENTRADA: Opcional, Se ingresa valor de codigo RUP a consultar, si no va = ""
    // ENTRADA: Opcional, Se ingresa valor de nombre RUP a consultar, si no va = ""
    // SALIDA: carga en el atributo de la clase "FormFeedlotTraslado fft" con el resultado
    public Respuesta BuscarRUPOrigen(int rupOrigen, String nomRupOrigen) throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
            Respuesta r;
            r = BuscarRUP(rupOrigen, nomRupOrigen,1); //origen
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    //</editor-fold>
    
    // Método público que invoca la busqueda de RUP Destino ingresado (búsqueda exacta)
    // ENTRADA: Opcional, Se ingresa valor de codigo RUP a consultar, si no va = ""
    // ENTRADA: Opcional, Se ingresa valor de nombre RUP a consultar, si no va = ""
    // SALIDA: carga en el atributo de la clase "FormFeedlotTraslado fft" con el resultado
    public Respuesta BuscarRUPDestino(int rupOrigen, String nomRupOrigen) throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
            Respuesta r;
            r = BuscarRUP(rupOrigen, nomRupOrigen,2); //destino
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    //</editor-fold>
    
    // Método privado que realiza la busqueda de RUP ingresado (búsqueda exacta)
    // ENTRADA: Opcional, Se ingresa valor de codigo RUP a consultar, si no va = ""
    // ENTRADA: Opcional, Se ingresa valor de nombre RUP a consultar, si no va = ""
    // ENTRADA: Se ingresa valor tipoRUP (1= Origen, 2= Destino)
    // SALIDA: carga en el atributo de la clase "FormFeedlotTraslado fft" con el resultado
    private Respuesta BuscarRUP(int rupOrigen, String nomRupOrigen, int tipoRUP) throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
            Respuesta r = new Respuesta();
            EstablecimientoDAO edao = new EstablecimientoDAO();
            Establecimiento e = new Establecimiento();
            if (rupOrigen != 0)
            {
                e = edao.getEstablecimientoByRup(rupOrigen);
            }
            else if (nomRupOrigen != "")
            {
                e = edao.getEstablecimientoByNombre(nomRupOrigen);
            }
            if (e.getRupId() != 0) //encontró RUP?
            {
                if (e.getRupStatus() == 0) //RUP desactivado
                {
                    r.setMensaje("RUP desactivado");
                    r.setStatus(false);
                    return r;
                }
                else
                {
                    r.setStatus(false);
                    r.setMensaje("TipoRUP no valido");
                    if(tipoRUP == 1) //origen
                    {
                        fft.setRupOrigen(e.getRupId());
                        fft.setNomRupOrigen(e.getRupNombre());
                        r.setStatus(true);
                        r.setMensaje("RUP Origen cargado");
                    }
                    else if (tipoRUP == 2) //destino
                    {
                        fft.setComuna(e.getRupComuna());
                        fft.setDireccion(e.getRupDireccion());
                        fft.setRupDestino(e.getRupId());
                        fft.setNomRupDestino(e.getRupNombre());
                        r.setStatus(true);
                        r.setMensaje("RUP Destino cargado");
                    }
                }
            }
            else
            {
                r.setStatus(false);
                r.setMensaje("RUP no encontrado");
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    //</editor-fold>
    
    // Método public que carga el DIIO ingresado
    // ENTRADA: Se ingresa valor de DIIO
    // SALIDA: carga en el atributo de la clase "List<GrillaFeedlotTraslado> listFeedlotTraslado" con el resultado
    public Respuesta CargarDIIO(int DIIO) throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
            Respuesta r = new Respuesta();        
            BusquedaDIIO buscaDiio = new BusquedaDIIO();
            Animal animal = buscaDiio.BuscarDIIO(DIIO);
            if(animal != null)
            {
                if(animal.getAnimalRupActual() == fft.getRupOrigen())
                {
                    this.animal = animal;
                    r.setStatus(true);
                    r.setMensaje("DIIO cargado");
                }
                else
                {
                    r.setMensaje("DIIO no pertenece a RUP");
                    r.setStatus(false);
                }
            }
            else
            {
                r.setStatus(false);
                r.setMensaje("DIIO no válido");
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    //</editor-fold>
    
    // Método público que realiza la llamada a cargar Excel según de traslados
    // ENTRADA: FileInputStream objeto que contiene excel con datos a rescatar
    // SALIDA: respuesta respecto a la carga realizada
    public Respuesta CargarExcelATrasladar(FileInputStream file) throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
            Respuesta r;
            r = CargarExcel(file, 1); //a trasladar
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    //</editor-fold>
    
    // Método público que realiza la llamada a cargar Excel según de confirmación
    // ENTRADA: FileInputStream objeto que contiene excel con datos a rescatar
    // SALIDA: respuesta respecto a la carga realizada
    public Respuesta CargarExcelAConfirmar(FileInputStream file) throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
            Respuesta r;
            r = CargarExcel(file, 2); //a confirmar
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    //</editor-fold>
    
    // Método privado que obtiene los datos de Excel y lo traslada a CargarDIIOAConfirmar o CargarDIIOATrasladar
    // ENTRADA: FileInputStream objeto que contiene excel con datos a rescatar
    // ENTRADA: tipoCarga, indica si es (1= a trasladar o 2= a confirmar)
    // SALIDA: Llama a CargarDIIOAConfirmar o CargarDIIOATrasladar
    private Respuesta CargarExcel(FileInputStream file, int tipoCarga) throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
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
                    
                    //DIIO
                    if(cellText.equals("PESO"))
                    {
                        aux2 = cell.getColumnIndex();
                    }
                    if(aux2 != -1 && cell.getColumnIndex()==aux2)
                    {
                        peso = Float.parseFloat(cellText);
                    } 
                    /* CARGA A  LISTA GRILLAFEEDLOT TRASLADO
                    if(tipoCarga == 2)
                        return CargarDIIOAConfirmar(DIIO, peso);
                    else
                        return CargarDIIOATrasladar(DIIO, peso);
                    */
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
    //</editor-fold>

    // Método público que guarda los eventos de los DIIOS cargados en la grilla
    // ENTRADA: sin entrada
    // SALIDA: se agregan registros en base de datos
    public Respuesta GuardarFeedlotTraslado() throws Exception
    // <editor-fold defaultstate="collapsed" desc="Código">
    {
        try 
        {
            Respuesta r = new Respuesta();
            r.setMensaje("Sin datos a cargar");
            r.setStatus(false);
            for (GrillaFeedlotTraslado arg : listFeedlotTraslado)
            {
                Date d = new Date();
                Evento ev = new Evento();
                ev.setAnimalId(arg.getAnimal().getAnimalId());   
                
                if(arg.getStatus()=="Por confirmar")
                {
                    ev.setCategoriaId(arg.getAnimal().getAnimalCategoriaActual());
                    ev.setEventoDs("Traslado Feedlot por confirmado");
                    ev.setEventoValor(0f);
                    ev.setEventotipoId(13); //Tipo evento "Traslado Destete Salida"
                    ev.setEstadoanimalId(arg.getAnimal().getAnimalEstadoActual());
                }
                else //Confirmado
                {
                    ev.setEstadoanimalId(2); // Estado = "Engorda"
                    if(arg.getAnimal().getAnimalCategoriaActual() == 1) //ternera
                        ev.setCategoriaId(5); //vaquilla engorda
                    else if(arg.getAnimal().getAnimalCategoriaActual() == 2) //ternero
                        ev.setCategoriaId(3); //torete engorda
                    else
                    ev.setCategoriaId(arg.getAnimal().getAnimalCategoriaActual());
                    
                    ev.setEventoDs("Traslado Feedlot confirmado");
                    ev.setEventoValor(1f);
                    ev.setEventotipoId(25); //Tipo evento "Traslado destete llegada"
                }
                ev.setEventoFechaEvento(d);
                ev.setEventoFechaReg(fft.getFechaTraslado());
                   
                EventoDAO edao = new EventoDAO();
                int idEvento = edao.add(ev); //agrega evento a la db
                if(idEvento != 0) 
                {
                    if(arg.getStatus()!="Por confirmar")
                    {
                        EventoRupDAO erdao = new EventoRupDAO();
                        EventoRup er = new EventoRup();
                        er.setEventoId(idEvento);
                        er.setRupId(fft.getRupDestino());
                        int idEventoRup = erdao.add(er);
                        if(idEventoRup != 0)
                        {
                           AnimalDAO adao = new AnimalDAO();
                            arg.getAnimal().setAnimalEstadoActual(ev.getEstadoanimalId()); //set estado actual
                            arg.getAnimal().setAnimalCategoriaActual(ev.getCategoriaId()); //set categoria actual
                            arg.getAnimal().setAnimalRupActual(fft.getRupDestino());
                            if(arg.getPeso()!=0)
                                arg.getAnimal().setAnimalPesoActual(arg.getPeso());
                            if(adao.update(arg.getAnimal()))
                            {
                                r.setStatus(true);
                                r.setMensaje("Registro actualizado Animal, y creado de: evento, eventoRup");
                            }
                            else
                            {
                                er.setEventorupId(idEventoRup);
                                erdao.delete(er); //borra registro eventoRup
                                ev.setEventoId(idEvento);
                                edao.delete(ev); //borra registro evento
                                r.setStatus(false);
                                r.setMensaje("Error en el guardado Animal");
                            } 
                        }
                        else
                        {
                            ev.setEventoId(idEvento);
                            edao.delete(ev);
                            r.setStatus(false);
                            r.setMensaje("Error en el guardado EventoRup");
                        }
                    }
                    else
                    {
                        r.setStatus(true);
                        r.setMensaje("Registro evento creado");
                    }
                }
                else
                {
                    r.setStatus(false);
                    r.setMensaje("Error en el guardado evento");
                }   
            }
            return r;
        } 
        catch (Exception e) 
        {
            throw e;
        }
    }
    //</editor-fold>
}