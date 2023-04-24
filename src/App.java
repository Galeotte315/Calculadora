import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class App implements ActionListener{
    
    private JTextField display;
    private double memoria;
    private String operacion;

    public static void main(String[] args) {
        menuClaculadora();
    }

    public static void menuClaculadora(){
        App app = new App();
        //contenido del teclado numerico
        String teclado[] = {"MC", "MR", "MS", "/", "7", "8", "9", "*", "4", "5", "6", "+", "3", "2", "1", "-", "="};

        //Creando el panel
        JPanel panel = new JPanel(new GridLayout(5,4));

        for (String s : teclado) {
            JButton button = new JButton(s);
            button.addActionListener(app);
            panel.add(button);
            
        }

        //Ventana
        JFrame  frame = new JFrame("Calculadora");
        app.display = new JTextField(20);//Esto
        frame.getContentPane().add(app.display, "North");//ESto
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);


        

        // String resultado = JOptionPane.showInputDialog(null, titulo+menu);

    }
    public void actionPerformed(ActionEvent e) {
        String boton = e.getActionCommand();

        if(!numeroTeclado(boton)){
            return;
        }else{
            switch (boton){
                case "+":
                    sumar();
                    break;
                case "-":
                    resta();
                    break;
                case "*":
                    multiplicacion();
                    break;
                case "/":
                    division();
                    break;
                case "=":
                    igual();
                    break;
                case "MC":
                    limpiarMemoria();
                    break;
                case "MR":
                    mostrarMemoria();
                    break;
                case "MS":
                    guardarMemoria();
                    break;
                
            }
        }
        
    }
    public boolean numeroTeclado(String texto) {
        for (int i = 0; i < texto.length(); i++) {
            if (!Character.isDigit(texto.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    private void sumar() {
        double numero = Double.parseDouble(display.getText());
        memoria += numero;
        display.setText(Double.toString(memoria));
    }

    private void resta() {
        double numero = Double.parseDouble(display.getText());
        memoria -= numero;
        display.setText(Double.toString(memoria));
    }

    private void multiplicacion() {
        double numero = Double.parseDouble(display.getText());
        memoria = memoria * numero;
        display.setText(Double.toString(memoria));
    }

    private void division() {
        double numero = Double.parseDouble(display.getText());
        memoria = memoria / numero;
        display.setText(Double.toString(memoria));
    }

    private void igual() {
        if (operacion != null){
            double numero = Double.parseDouble(display.getText());
            double res= 0.0;
            switch(operacion){
                case "+":
                    sumar();
                    break;
                case "-":
                    resta();
                    break;
                case "*":
                    multiplicacion();
                    break;
                case "/":
                    division();
                    break;
            }
        }
    }

    private void limpiarMemoria() {
        double numero = Double.parseDouble(display.getText());
        
    }

    private void mostrarMemoria() {
        double numero = Double.parseDouble(display.getText());
       
    }

    private void guardarMemoria() {
        double numero = Double.parseDouble(display.getText());
        
    }

    
    
}
