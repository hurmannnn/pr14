import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] dates = new String[50];
        String[] notes = new String[50];//масив у який буде записано дати та записи до них
        int count = 0;//лічильник записів зараз

        while (true) {//цикл який працює поки користувач з нього не вийде
            System.out.println("1-Додати дату");
            System.out.println("2-Видалити дату");
            System.out.println("3-Показати дату");
            System.out.println("4-Вихід");
            String choice = sc.nextLine();

            if (choice.equals("1")) {//якщо введене число 1

                System.out.print("Введіть дату (рік-місяць-число): ");//треба ввести дату
                String date = sc.nextLine();

                try {//перевірка дати
                    LocalDate.parse(date);//перевірка формату дати
                } catch (Exception e) {
                    System.out.println("Неправильна дата");
                    continue;//неправильно написана дата - повертає
                }

                System.out.println("Введіть текст (щоб завершити запис натисність /):");//вихід з запису

                String text = "";//змінна для збереження записів
                while (true) {//цикл який працює поки користувач не натисне слеш
                    String line = sc.nextLine();
                    if (line.equals("/"))
                        break;
                    text = text + line;//додавання рядка до тексту
                }

                dates[count] = date;
                notes[count] = text;
                count++;//записує дату та текст у масив і збільшує кількість записів

                System.out.println("Додано");
            }

            else if (choice.equals("2")) {//якщо число 2 можна видалити запис
                System.out.print("Введіть дату: ");
                String d = sc.nextLine();

                boolean found = false;//пошук запису чи є він взагалі

                for (int i = 0; i < count; i++) {//пошук запису проходячи усі записи
                    if (dates[i].equals(d)) {//якщо дата співпала
                        for (int j = i; j < count - 1; j++) {
                            dates[j] = dates[j + 1];
                            notes[j] = notes[j + 1];//усі записи зсуваються щоб прибрати обраний запис
                        }

                        count--;
                        found = true;
                        System.out.println("Видалено!");
                        break;//зменьшення кількості, дату знайдено і вихід з циклу
                    }
                }

                if (!found) {//якщо дати не знайдено
                    System.out.println("Не знайдено дати");
                }
            }

            else if (choice.equals("3")) {//якщо число 3
                if (count == 0) {//якщо дати не знайдено
                    System.out.println("Немає такої дати");
                } else {//показ усіх записів та обрану дату
                    for (int i = 0; i < count; i++) {
                        System.out.println("Дата: " + dates[i]);
                        System.out.println(notes[i]);
                    }
                }
            }

            else if (choice.equals("4")) {
                break;//вихід з головного циклу
            }

            else {
                System.out.println("Невірний вибір");//якщо немає обраної опції
            }
        }

        sc.close();
    }
}