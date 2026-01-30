import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class lerTarefas {
  public salvarTarefa salvarTarefa = new salvarTarefa();
  private LocalDate dia = LocalDate.now();

  private String[] tarefasIds = new String[] {};
  private String[] newTarefasIds;

  public tarefa tarefa;
  private String texto = "";

  private File file = new File("pastaSalvar/Tarefas_dia_" + dia.toString() +
      ".txt");

  public void atualizaTexto() {

    try (FileReader fr = new FileReader(file)) {
      int j;

      while ((j = fr.read()) != -1) {
        texto += (char) j;
      }
    } catch (

    IOException e) {
      e.printStackTrace();
    }

  }

  public void visualizarTarefas() {

    atualizaTexto();

    if (texto.isBlank()) {
      System.out.println("Sem tarefa");

    } else {
      tarefasIds = texto.split("\\n");

      for (int i = 0; i < tarefasIds.length; i++) {

        System.out.println("id: " + i + " " + tarefasIds[i]);
      }
      texto = "";

    }
  }

  public void visualizarTarefasSemRetorno() {

    atualizaTexto();

    if (texto.isBlank()) {
      System.out.println("Sem tarefa");

    } else {
      tarefasIds = texto.split("\\n");

      texto = "";

    }
  }

  public void newArray(int id) {
    newTarefasIds = new String[tarefasIds.length - 1];
    int j = 0;
    int indexRemover = 0;
    for (int i = 0; i < tarefasIds.length; i++) {
      if (i != indexRemover) {
        newTarefasIds[j] = tarefasIds[i];
        j++;
      }
    }
  }

  public void deleteTarefa(int id) {
    newArray(id);
    salvarTarefa.deletarInfoArquivo(file);

    for (int i = 0; i < newTarefasIds.length; i++) {

      salvarTarefa.salvar(newTarefasIds[i]);
    }
  }
}
