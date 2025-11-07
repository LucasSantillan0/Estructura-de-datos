package edd.tp3.E5;

import java.util.ArrayList;
import java.util.Optional;

import edd.common.Helper;
import edd.common.Input;
import edd.tp1.Common.Menu;

public class Main {

  static StackGenerica<String> tagStack = new StackGenerica<String>();
  static StackGenerica<String> stack = new StackGenerica<String>();

  public static void main(String[] args) {
    ArrayList<String> options = new ArrayList<>();
    options.add("Generar etiquetas");
    options.add("Buscar etiqueta");
    options.add("Expandir etiqueta");
    System.out.println("Escriba una palabra clave para generar las etiquetas:");
    String input = Input.ReadLine();
    String[] characters = input.split("");
    stack = new StackGenerica<String>();
    for (String character : characters) {
      stack.push(character);
    }
    System.out.println(stack);
    Menu.showMenu(options, (Integer optionSelected) -> {

      switch (optionSelected) {
        case 1:
          System.out.println("Generando etiquetas...");
          tagStack = generateTags(stack);
          System.out.println(tagStack);
          break;

        case 2:
          if (tagStack.isEmpty()) {
            System.out.println("Primero debe generar las etiquetas");
            break;
          }
          System.out.println("Buscando etiqueta...");
          System.out.println("Ingrese la etiqueta a buscar:");
          String tagToSearch = Input.ReadLine();
          Optional<String> foundTag = searchTag(tagStack, tagToSearch);
          if (foundTag.isPresent()) {
            System.out.println("Etiqueta encontrada: " + foundTag.get());
          } else {
            System.out.println("Etiqueta no encontrada.");
          }
          break;

        case 3:
          if (tagStack.isEmpty()) {
            System.out.println("Primero debe generar las etiquetas");
            break;
          }
          System.out.println("Reconstruyendo stack...");
          StackGenerica<String> reconstructedStack = reconstructStack(tagStack);
          System.out.println("Stack reconstruido: " + reconstructedStack);
          break;

        default:
          break;
      }
    });
  }

  static StackGenerica<String> generateTags(StackGenerica<String> stack) {
    StackGenerica<String> copy = copyStack(stack);
    StackGenerica<String> tagStack = new StackGenerica<String>();
    String lastChar = copy.pop();
    int repeatCount = 1;
    while (!copy.isEmpty()) {
      String character = copy.pop();
      try {
        copy.peek();
      } catch (RuntimeException e) {
        tagStack.push(lastChar + (lastChar.equals(character) ? repeatCount + 1 : repeatCount));
        if (!lastChar.equals(character)) {
          tagStack.push(character + 1);
        }
        continue;
      }
      if (lastChar.equals(character)) {
        repeatCount++;
        continue;
      }
      tagStack.push(lastChar + repeatCount);
      lastChar = character;
      repeatCount = 1;
    }
    return tagStack;
  }

  static Optional<String> searchTag(StackGenerica<String> stack, String tag) {
    StackGenerica<String> copy = copyStack(stack);
    while (!copy.isEmpty()) {
      String currentTag = copy.pop();
      String character = currentTag.substring(0, 1);
      if (character.equals(tag)) {
        return Optional.of(currentTag);
      }
    }
    return Optional.empty();
  }

  static StackGenerica<String> reconstructStack(StackGenerica<String> tagStack) {
    StackGenerica<String> copy = copyStack(tagStack);
    StackGenerica<String> reconstructedStack = new StackGenerica<String>();
    while (!copy.isEmpty()) {
      String tag = copy.pop();
      String character = tag.substring(0, 1);
      int count = Integer.parseInt(tag.substring(1));
      for (int i = 0; i < count; i++) {
        reconstructedStack.push(character);
      }
    }
    return reconstructedStack;
  }

  static <T> StackGenerica<T> copyStack(StackGenerica<T> original) {
    StackGenerica<T> copy = new StackGenerica<T>();
    StackGenerica<T> temp = new StackGenerica<T>();

    while (!original.isEmpty()) {
      T element = original.pop();
      temp.push(element);
    }

    while (!temp.isEmpty()) {
      T element = temp.pop();
      original.push(element);
      copy.push(element);
    }
    System.out.println("Stack original: " + original);
    System.out.println("Stack copiado: " + copy);
    return copy;
  }
}
