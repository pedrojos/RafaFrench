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
    private boolean estado;

    private static ArrayList<Plato> platos = new ArrayList<>();

    public Plato(int cod, String nom, String fecha, int val_c, int val_v, boolean estado) {

        this.codigo = cod;
        this.nombre = nom;
        this.fecha = fecha;
        this.val_costo = val_c;
        this.val_venta = val_v;
        this.estado = estado;

    }

    public Plato() {

    }

    public boolean agregar() {
        boolean resul = false;
        try {
            platos.add(new Plato(this.codigo, this.nombre, this.fecha, this.val_costo, this.val_venta, this.estado));
            resul = true;
        } catch (Exception ex) {
            System.out.println("Error al guardar en arrayList" + ex.getMessage());
        }

        return resul;
    }

    public boolean existe(int codi) {
        boolean resul = false;
        for (int i = 0; i < platos.size(); i++) {
            if ((platos.get(i).codigo) == codi) {
                resul = true;
                break;
            }
        }

        return resul;
    }

    public boolean existnom(String nom) {
        boolean result = false;

        for (int i = 0; i < platos.size(); i++) {
            if ((platos.get(i).nombre).equals(nom)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean verificarexistencia(ArrayList<Plato> a, String doc) {

        for (int i = 0; i < a.size(); i++) {

            if (doc.equals(a.get(i).codigo)) {

                System.out.println("Nombre: " + a.get(i).nombre);
                System.out.println("Valor Venta: " + a.get(i).val_venta);
                System.out.println("Valor Compra: " + a.get(i).val_costo);
            } else {

                System.out.println("Plato No Registrado");
                System.out.println("");

            }
        }
        return true;
    }

    public boolean cambiarn(ArrayList<Plato> a, String nombre) {

        for (int i = 0; i < a.size(); i++) {

            if (nombre.equals(a.get(i).nombre)) {

                System.out.println("El Nombre Ya Existe");
                System.out.println("");

            } else {

                a.get(i).nombre = nombre;
                System.out.println("Actualizado Satisfactoriamente");
                System.out.println("");
                break;
            }
        }
        return true;

    }

    public boolean cambiarv(ArrayList<Plato> a, int venta, String c) {

        for (int i = 0; i < a.size(); i++) {

            if (venta <= a.get(i).val_costo) {

                System.out.println("El Valor De La Venta No Puede Ser Igual Ni Menor Al De La Compra");
                System.out.println("");
            } else {

                a.get(i).val_venta = venta;
                System.out.println("Actualizado Satisfactoriamente");
                System.out.println("");
                break;
            }

        }
        return true;
    }

    public boolean cambiarc(ArrayList<Plato> a, int compra, String co) {

        for (int i = 0; i < a.size(); i++) {

            if (compra >= a.get(i).val_venta) {

                a.get(i).val_costo = compra;
                System.out.println("El Valor De La Compra No Puede Ser Igual Ni Mayor Al De La Venta");
                System.out.println("");
            } else {
                a.get(i).val_costo = compra;
                System.out.println("Actualizado Satisfactoriamente");
                System.out.println("");
                break;
            }

        }
        return true;

    }

}
