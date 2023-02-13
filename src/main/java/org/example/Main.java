package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonnelController personnelController=new PersonnelController();
        /*Scanner input=new Scanner(System.in);
        System.out.print("Ad: ");
        String name=input.nextLine();
        System.out.print("Soyad: ");
        String surname=input.nextLine();*/

        // Insert
        /*PersonnelModel personnelModel=new PersonnelModel(name,surname);

        personnelController.insert(personnelModel);*/

        // Batch Insert Birden Fazla Ekleme
        /*ArrayList<PersonnelModel> personnelModelList=new ArrayList<>();
        personnelModelList.add(new PersonnelModel("Ali","Kaçan"));
        personnelModelList.add(new PersonnelModel("Serhat","Kaçan"));
        personnelModelList.add(new PersonnelModel("Kemal","Kaçan"));
        personnelModelList.add(new PersonnelModel("Derviş","Kaçan"));
        personnelController.insertPersonnelList(personnelModelList);*/

        // Update
        /*PersonnelModel personnelModel1=new PersonnelModel(39,"Yakup","Şahin");
        personnelController.update(personnelModel1);*/

        // Delete
        /*PersonnelModel personnelModel2=new PersonnelModel(44);
        personnelController.delete(personnelModel2);*/

        // Search Id
        /*PersonnelModel personnelModel=new PersonnelModel(43);
        PersonnelModel resultPerson=personnelController.searchId(personnelModel);
        System.out.println("Id: " + resultPerson.getId() +
                " Name: " + resultPerson.getName() +
                " Surname: " + resultPerson.getSurname()
        );*/

        // List
        ArrayList<PersonnelModel> personnelModels=personnelController.list();
        for (PersonnelModel personnelModel:personnelModels) {
            System.out.println("Id: " + personnelModel.getId() +
                    " Name: " + personnelModel.getName() +
                    " Surname: " + personnelModel.getSurname()
            );
        }
    }
}