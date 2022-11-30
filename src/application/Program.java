package application;

import entities.Lesson;
import entities.Task;
import entities.Video;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Lesson> list = new ArrayList<>();

        System.out.print("Quantas aulas tem o curso? ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Dados da " + (i + 1) + "ª aula:");
            System.out.print("Conteúdo ou tarefa (c/t): ");
            char resp = sc.next().charAt(0);
            sc.nextLine();
            if (resp == 'c' || resp == 'C') {
                System.out.print("Titulo: ");
                String title = sc.nextLine();
                System.out.print("URL do video: ");
                String url = sc.nextLine();
                System.out.print("Duração em segundos: ");
                int seconds = sc.nextInt();
                list.add(new Video(title, url, seconds));
            } else {
                System.out.print("Titulo: ");
                String title = sc.nextLine();
                System.out.print("Descrição: ");
                String description = sc.nextLine();
                System.out.print("Quantidade de questões: ");
                int questionsCount = sc.nextInt();
                list.add(new Task(title, description, questionsCount));
            }
        }
        System.out.println();
        int sum = 0;
        for (Lesson e : list) {
            sum += e.duration();
        }
        System.out.print("DURAÇÃO TOTAL DO CURSO = " + sum + " segundos");
        sc.close();
    }
}
