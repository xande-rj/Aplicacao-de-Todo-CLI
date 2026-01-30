import java.util.Scanner;

public class tarefa {
  private String nomeTarefa;
  private Tarefas tarefas = new Tarefas();
  public tarefa tarefa;

  private lerTarefas lerTarefas = new lerTarefas();
  private salvarTarefa salvarTarefa = new salvarTarefa();
  private statusTarefa status;

  private updateTarefa updateTarefa = new updateTarefa();

  tarefa() {
  }

  public tarefa(String nomeTarefa) {
    this.nomeTarefa = nomeTarefa;
  }

  public void setStatus(statusTarefa status) {
    this.status = status;
  }

  public void setStatusTarefa(int i) {
    switch (i) {
      case 1:
        tarefa.setStatus(statusTarefa.CONCLUIDO);
        System.out.println("Tarefa criada com sucesso");
        tarefas.setTarefa(tarefa);
        inicio();

        break;
      case 2:
        tarefa.setStatus(statusTarefa.EM_ANDAMENTO);
        System.out.println("Tarefa criada com sucesso");
        tarefas.setTarefa(tarefa);
        inicio();
        break;

      case 3:
        tarefa.setStatus(statusTarefa.NAO_CONCLUIDO);
        System.out.println("Tarefa criada com sucesso");
        tarefas.setTarefa(tarefa);
        inicio();
        break;

      default:
        inicio();
        break;

    }

  }

  public void caso(Scanner sc) {

    switch (sc.nextInt()) {
      case 1:
        Scanner sC = new Scanner(System.in);
        System.out.println("digite o nome da tarefa: ");

        tarefa = new tarefa(sC.nextLine());

        System.out.println("Escolha o status da tarefa:\n1 - CONCLUIDO \n2 - EM ANDAMENTO\n3 - NAO_CONCLUIDO");
        setStatusTarefa(sc.nextInt());
      case 2:
        lerTarefas.visualizarTarefas();
        inicio();
        break;
      case 3:
        lerTarefas.visualizarTarefas();
        System.out.println("Qual tarefa deseja atualizar: ");
        String[] textAtt = updateTarefa.upTarefa(sc.nextInt());

        System.out.println("Digite o novo nome da tarefa: ");
        sc.nextLine();
        textAtt[1] = sc.nextLine();

        System.out.println("Escolha o novo status da tarefa:\n1 - CONCLUIDO \n2 - EM ANDAMENTO\n3 - NAO_CONCLUIDO");
        switch (sc.nextInt()) {
          case 1:

            tarefa = new tarefa(textAtt[1]);
            tarefa.setStatus(statusTarefa.CONCLUIDO);
            salvarTarefa.salvar(tarefa.toString());
            System.out.println("Tarefa salva com sucesso");
            inicio();

            break;
          case 2:

            tarefa = new tarefa(textAtt[1]);
            tarefa.setStatus(statusTarefa.EM_ANDAMENTO);
            salvarTarefa.salvar(tarefa.toString());
            System.out.println("Tarefa salva com sucesso");
            inicio();
            break;

          case 3:

            tarefa = new tarefa(textAtt[1]);
            tarefa.setStatus(statusTarefa.NAO_CONCLUIDO);
            salvarTarefa.salvar(tarefa.toString());
            System.out.println("Tarefa salva com sucesso");
            inicio();
            break;

          default:
            inicio();
            break;

        }

        inicio();
        break;

      case 4:
        lerTarefas.visualizarTarefas();
        System.out.println("Qual tarefa deseja deletar: ");
        lerTarefas.deleteTarefa(sc.nextInt());
        lerTarefas.visualizarTarefas();
        inicio();
        break;

      case 5:
        if (this.tarefas.size() == 0) {
          System.out.println("Por favor adicione tarefas a salvar.");
          inicio();
        }

        for (int i = 0; i < this.tarefas.size(); i++) {
          salvarTarefa.salvar(this.tarefas.returnTarefa(i));
        }

        this.tarefas.deletarArray();
        break;

      case 6:
        break;
    }
  }

  public void inicio() {
    Scanner sc = new Scanner(System.in);

    System.out.println(
        "Informe o deseja fazer:\n 1 - Adicionar uma tarefa\n 2 - Visualizar tarefas \n 3 - Atualizar tarefas \n 4 - Deletar tarefa \n 5 - Salvar \n 6 - Sair\n");
    caso(sc);
  }

  @Override
  public String toString() {
    return "Tarefa : " + this.nomeTarefa + ", Status: " + this.status;
  }

}
