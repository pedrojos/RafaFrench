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
}
