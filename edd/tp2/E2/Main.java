package edd.tp2.E2;

import java.util.ArrayList;

import edd.tp1.Common.Menu;

public class Main {

  public static void main(String[] args) {

    Product netbook = new Product("Netbook", 999.99f, 10);
    Product smartphone = new Product("Smartphone", 599.99f, 20);

    Menu.showMenu(new ArrayList<>() {
      {
        add("Vender netbook");
        add("Reponer 1 netbook");
        add("Vender smartphone");
        add("Reponer 1 smartphone");
      }
    }, (option) -> {
      switch (option) {
        case 1:
          netbook.sell();
          break;
        case 2:
          netbook.restock(1);
          break;
        case 3:
          smartphone.sell();
          break;
        case 4:
          smartphone.restock(1);
          break;
      }
    });
  }

}
