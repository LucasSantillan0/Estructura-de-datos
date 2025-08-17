package edd.tp1.E2;

import java.util.ArrayList;

import edd.tp1.Common.Input;
import edd.tp1.Common.Menu;

public class Main {
  public static void main(String[] args) {
    Menu.showMenu(new ArrayList<String>() {
      {
        add("Dados");
      }
    }, (_) -> {
      System.out.println("Cuantas tiradas desea realizar?");
      int times = Input.ReadNumber();
      System.out.println("Tiradas: " + times);
      for (int i = 0; i < times; i++) {
        int result = (int) (Math.random() * 6) + 1;
        System.out.println("Tirada " + (i + 1) + " Dado 1: " + result);
        int result2 = (int) (Math.random() * 6) + 1;
        System.out.println("Tirada " + (i + 1) + " Dado 2: " + result2);
      }
    });
  }
}
