import java.util.ArrayList;

public class Tarefas {
  private static ArrayList<tarefa> tarefas = new ArrayList<>();

  public void setTarefa(tarefa tarefa) {
    Tarefas.tarefas.add(tarefa);
  }

  public ArrayList<tarefa> showTarefas() {
    return tarefas;
  }

  public int size() {
    return Tarefas.tarefas.size();
  }

  public String returnTarefa(int index) {
    return Tarefas.tarefas.get(index).toString();
  }

  public void deletarArray() {
    for (int i = 0; i < tarefas.size(); i++) {
      tarefas.remove(i);
    }
  }
}
