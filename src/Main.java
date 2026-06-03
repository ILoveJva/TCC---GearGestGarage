import view.controller.ViewController;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            try {
                // Instancia e inicia apenas o Controlador de Telas (Front-end)
                ViewController viewController = new ViewController();
                viewController.iniciarAplicacao();

                // Nota: A inicialização do OficinaController e banco de dados
                // será feita depois e conectada ao ViewController conforme necessário.

            } catch (Exception e) {
                System.err.println("Erro ao inicializar a interface visual: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }
}