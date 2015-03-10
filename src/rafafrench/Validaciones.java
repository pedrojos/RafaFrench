package rafafrench;

import javax.swing.JTextField;

/**
 *
 * @author Pedro José Jiménez Ochoa
 */
public class Validaciones {

    public void SoloNumeros(java.awt.event.KeyEvent evt) {
        char caracter = evt.getKeyChar();
         //ESTA ES OTRA FORMA DE HACER LA VALIDACION, EN ESTE CASA UTILIZAMOS LA SEGUNDA OPCION
      /*  if (caracter < '0' || caracter > '9') {
         evt.consume();
         } */
        if (Character.isLetter(caracter)) {
            evt.consume();
        }
    } //FIN DE METODO SOLONUMEROS

    public void SoloLetras(java.awt.event.KeyEvent evt) {
        char caracter = evt.getKeyChar();

        if (Character.isDigit(caracter)) {
            evt.consume();
        }
    } //FIN METODO SOLOLETRAS

    public void limitar(JTextField txt,int limite, java.awt.event.KeyEvent evt){
         if (txt.getText().length() == limite) {
             evt.consume();
         }
    }
}
