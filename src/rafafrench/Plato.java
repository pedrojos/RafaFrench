package rafafrench;

import java.util.ArrayList;

/**
 *
 * @author sena
 */
public final class Plato {

    private int codigo;
    private String nombre;
    private String fecha;
    private int val_costo;
    private int val_venta;
    private String estado;
<<<<<<< HEAD
 
    Conexion obj = new Conexion("mysql", "com.mysql.jdbc.Driver", "localhost", "rafafrench", "root", "1234");
=======

    Conexion obj = new Conexion("mysql", "com.mysql.jdbc.Driver", "localhost", "rafafrench", "root", "");
>>>>>>> 5ff657bc82be75357b79bdf88f45c9bbac115c50

    private static ArrayList<Plato> platos = new ArrayList<>();

    public Plato(int cod, String nom, String fecha, int val_c, int val_v, String estado) {

        this.codigo = cod;
        this.nombre = nom;
        this.fecha = fecha;
        this.val_costo = val_c;
        this.val_venta = val_v;
        this.estado = estado;

    }

    public Plato() {

    }

    public void refreh() {
        Object[][] datos;
        String campos = "codigo, nombre_plato, fecha_ingreso, costo, valor_venta, estado";
        datos = obj.consulta("platos", campos, null);
        if (datos.length > 0) {
            System.out.println("Datos obtenidos");
            for (int i = 0; i < datos.length; i++) {
                this.codigo = Integer.parseInt((String) datos[i][0]);
                this.nombre = (String) datos[i][1];
                this.fecha = (String) datos[i][2];
                this.val_costo = Integer.parseInt((String) datos[i][3]);
                this.val_venta = Integer.parseInt((String) datos[i][4]);
                this.estado = (String) datos[i][5];

                platos.add(new Plato(this.codigo, this.nombre, this.fecha, this.val_costo, this.val_venta, this.estado));
            }

        }
        obj.desconectar();
    }

    public boolean agregar() {
        boolean resul = false;
        String campos = "codigo, nombre_plato, fecha_ingreso, costo, valor_venta, estado";
        try {
            platos.add(new Plato(this.codigo, this.nombre, this.fecha, this.val_costo, this.val_venta, this.estado));
        } catch (Exception ex) {
            System.out.println("Error al guardar en arrayList \n" + ex.getMessage());
        }
        try {

            if (obj.insertar("platos", campos, "" + this.codigo + ", '" + this.nombre + "', '" + this.fecha + "', " + this.val_costo + ", " + this.val_venta + ", '" + this.estado + "' ")) {
                resul = true;
            }

        } catch (Exception ex) {
            System.out.println("Error al llamar al metodo insertar\n" + ex.getMessage());
        }

        return resul;
    }

    //Metodos sobrecargados
    public int existe(int codi) {
        int resul = -1;
        for (int i = 0; i < platos.size(); i++) {
            if ((platos.get(i).codigo) == codi) {
                resul = i;
                break;
            }
        }

        return resul;
    }

    public boolean existe(String nom) {
        boolean result = false;

        for (Plato plato : platos) {
            if ((plato.nombre).equals(nom)) {
                result = true;
                break;
            }
        }
        return result;
    }
    //metodos sobrecargados

    public Plato consultar(int cod) {
        Plato p = new Plato();
        for (int i = 0; i < platos.size(); i++) {
            if (platos.get(i).codigo == cod) {
                p = platos.get(i);
                break;
            }
        }

        return p;
    }

    //Metodo nuevo plato
    public int nuevo_plato() {
        int num = 0;
        for (int i = 0; i < platos.size(); i++) {
            if ((platos.get(i).codigo) > num) {
                num = platos.get(i).codigo;
            }
        }
        return 1 + num;
    }

    //-------------------------------Metodos actualizar
    public boolean actualizar(int pos) {
        boolean resul = false;

        platos.get(pos).nombre = this.nombre;
        platos.get(pos).val_costo = this.val_costo;
        platos.get(pos).val_venta = this.val_venta;
        platos.get(pos).estado = this.estado;
        System.out.println(this.estado);

        /**
         * Campos que deben ir al llamar al metodo update tabla, campos,
         * condicion, valores[]
         */
        String campos = "nombre_plato, costo, valor_venta, estado";
        Object[] valores = {this.nombre, this.val_costo, this.val_venta, this.estado};
        try {
            if (obj.update("platos", campos, "codigo =" + this.codigo, valores)) {
                resul = true;
            }

        } catch (Exception ex) {
            System.out.println("Error al llamar al metodo upd \n" + ex.getMessage());
        }

        return resul;
    }

    //METODOS SETTER
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setVal_costo(int val_costo) {
        this.val_costo = val_costo;
    }

    public void setVal_venta(int val_venta) {
        this.val_venta = val_venta;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //Metodos getter
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public int getVal_costo() {
        return val_costo;
    }

    public int getVal_venta() {
        return val_venta;
    }

    public String getEstado() {
        return estado;
    }

}
