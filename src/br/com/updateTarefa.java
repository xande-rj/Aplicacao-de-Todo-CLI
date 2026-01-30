import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class updateTarefa {
  String texto = "";
  private String[] tarefasIds = new String[] {};
  private LocalDate dia = LocalDate.now();
  public lerTarefas ler = new lerTarefas();
  private File file = new File("pastaSalvar/Tarefas_dia_" + dia.toString() +
      ".txt");

  public void test() {
    try (FileReader fr = new FileReader(file)) {
      int j;

      while ((j = fr.read()) != -1) {
        texto += (char) j;
      }
    } catch (

    IOException e) {
      e.printStackTrace();
    }
    if (texto.isBlank()) {
      System.out.println("Sem tarefa");

    } else {
      tarefasIds = texto.split("\\n");

      texto = "";

    }
  }

  public String[] upTarefa(int id) {
    test();
    String tarefa = tarefasIds[id];
    ler.visualizarTarefasSemRetorno();
    ler.deleteTarefa(id);
    return tarefa.split("Tarefa\\s*:\\s*|,\\s*Status\\s*:\\s*|;");

  }
}
