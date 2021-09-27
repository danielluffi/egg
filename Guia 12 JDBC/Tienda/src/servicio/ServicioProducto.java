/*
 * Sin licencia.
 * Uso para capacitación
 * 2021 Año de la Prevención y Lucha contra el COVID-19.
 */
package servicio;

import entidad.Producto;
import excepcion.MiExcepcion;
import java.util.List;
import persistencia.ProductoDAO;

/**
 *
 * @author Adrian E. Camus
 */
public class ServicioProducto {
 
      private ProductoDAO pDAO;

    public ServicioProducto() {
    pDAO = new ProductoDAO();
    }

//CREA NUEVO    
    public void crearProducto(Integer codigo, String nombre, Double precio, Integer cod_fab) throws MiExcepcion {
        try {
            // VALIDACIÓN
            if (codigo == null | codigo < 0) {
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO");
            }

            if (nombre == null | nombre.trim().isEmpty()) {
                throw new MiExcepcion("DEBE INGRESAR UN NOMBRE");
            }
            
            if (precio == null | precio < 0) {
                throw new MiExcepcion("DEBE INGRESAR UN PRECIO");
            }
            
            if (cod_fab == null | cod_fab < 0) {
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO DE FABRICANTE");
            }
                        
            Producto p = new Producto();

            p.setCodigo(codigo);
            p.setNombre(nombre);
            p.setPrecio(precio);
            p.setCodigoFabricante(cod_fab);
            pDAO.guardarProducto(p);
            
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

//MODIFICA
    public void modificarFabricante(Integer codigo, String nombre) throws MiExcepcion {
        try {
            // VALIDACIÓN
            if (codigo == null | codigo < 0) {
                throw new MiExcepcion("DEBE INGRESAR UN CODIGO");
            }

            if (nombre == null | nombre.trim().isEmpty()) {
                throw new MiExcepcion("DEBE INGRESAR UN NOMBRE");
            }

            Fabricante fabricante = f.buscarFabricantePorCodigo(codigo);

            if (fabricante == null) {
                throw new MiExcepcion("EL CODIGO INGRESADO NO ESTÁ ASOCIADO A NINGÚN FABRICANTE");
            }

            fabricante.setNombre(nombre);

            f.modificarFabricante(fabricante);
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

//ELIMINA
    public void eliminarFabricante(Integer cod) throws MiExcepcion {
        try {
            if (cod == null || cod<0 ) {
                throw new MiExcepcion("DEBE INGRESAR UN CORREO");
            }

            Fabricante fabricante = f.buscarFabricantePorCodigo(cod);

            if (fabricante == null) {
                throw new MiExcepcion("EL CORREO INGRESADO NO ESTÁ ASOCIADO A NINGÚN USUARIO");
            }

            f.eliminarFabricante(cod);
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }

//MUESTRA    
    public void muestraFabricantes() throws MiExcepcion {
        try {
            List<Fabricante> fabricantes = f.obtenerFabricante();

            if (fabricantes.isEmpty()) {
                throw new MiExcepcion("NO EXISTEN FABRICANTES");
            } else {
                System.out.println("*** LISTA DE FABRICANTES ***");
                System.out.printf("%-20s%-15s\n", "CODIGO", "NOMBRE"); // FORMATO DE IMPRESIÓN
                for (Fabricante aux : fabricantes) {
                    System.out.println(aux);
                }
                System.out.println();
            }
        } catch (MiExcepcion e) {
            // e.printStackTrace();
            throw e;
        } catch (Exception e) {
            // e.printStackTrace();
            throw new MiExcepcion("ERROR DE SISTEMA");
        }
    }
    
    
    
    
    
    
}
