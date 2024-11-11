package pacientes;


import pacientes.Paciente;

import java.util.ArrayList;
import java.util.Scanner;


public class CadastroPaciente {
	
	private ArrayList<Paciente> pacientes;
	public CadastroPaciente() {
		this.pacientes = new ArrayList<>(); 
	}
	
	
	public void addPaciente(int idNum, String name,	double weight,	double height,	char gender) {
		Paciente paciente = new Paciente(idNum, name, weight, height, gender);
		pacientes.add(paciente);
		System.out.println("Patient added with success");
	}
	
	
	public void listPaciente() {
		if (pacientes.isEmpty()) {
			System.out.println("Nenhum Paciente Cadastrado");
		} else {
			System.out.println("\n\nLista de Pacientes Cadastrados: ");
			for (Paciente paciente : pacientes) {
				paciente.listarPaciente();
				
			}
		}
	}
	
	
	public void updatePaciente(int idNum){
		Paciente paciente = searchIdPaciente(idNum);
		if(paciente != null) {
            Scanner scanner = new Scanner(System.in);
            
            System.out.print("Novo nome do Paciente: ");
            String newName = scanner.nextLine();
            
            System.out.print("Novo Peso do Paciente: ");
            double newWeight = scanner.nextDouble();
            
            System.out.print("Novo Altura do Paciente: ");
            double newheight = scanner.nextDouble();
            
            paciente.setName(newName);
            paciente.setWeight(newWeight);
            paciente.setHeight(newheight);
            System.out.println("Paciente alterado com sucesso!");
			
		} else{
            System.out.println("Paciente com ID " + idNum + " não encontrado.");
		}
		
	}
	
	
    public void deletePaciente(int idNum) {
        Paciente paciente = searchIdPaciente(idNum);
        if (paciente != null) {
            pacientes.remove(paciente);
            System.out.println("Paciente excluído com sucesso!");
        } else{
            System.out.println("Paciente com ID " + idNum + " não encontrado.");
        }
    }

    
    private Paciente searchIdPaciente(int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getIdNum() == id) {
                return paciente;
            }
        }
        return null;
    }
	
    
    
    
	
//========================================================================================	
	public static void main(String[] args) {
		
        CadastroPaciente cadastro = new CadastroPaciente();
        Scanner scanner = new Scanner(System.in);
        
        int menu;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Listar Pacientes");
            System.out.println("3. Alterar Paciente");
            System.out.println("4. Excluir Paciente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            menu = scanner.nextInt();

            switch (menu) {
            
                case 1:
                    System.out.print("ID do Paciente: ");
                    int idNum = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer do scanner
                    
                    System.out.print("Nome do Paciente: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Peso do Paciente: ");
                    double weight = scanner.nextDouble();
                    System.out.print("Altura do Paciente: ");
                    double height = scanner.nextDouble();
                    
                    System.out.print("Sexo do Paciente: ");
                    char gender = scanner.next().charAt(0);
                    
                    cadastro.addPaciente(idNum, name, weight, height, gender);
                    break;
                    
                case 2:
                    cadastro.listPaciente();
                    break;
                    
                case 3:
                    System.out.print("ID do Paciente a alterar: ");
                    int idAlterar = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    cadastro.updatePaciente(idAlterar);
                    break;
                    
                case 4:
                    System.out.print("ID do Paciente a excluir: ");
                    int idExcluir = scanner.nextInt();
                    cadastro.deletePaciente(idExcluir);
                    break;
                    
                case 0:
                    System.out.println("Encerrando o programa.");
                    break;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (menu != 0);

        scanner.close();

	}

}
