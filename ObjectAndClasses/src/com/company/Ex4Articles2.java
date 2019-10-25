package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex4Articles2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Article> list = new ArrayList<Article>();
        int n = Integer.parseInt(scanner.nextLine());

        for(int i=0; i<n;i++) {
            String article = scanner.nextLine();
            String[] articleProps = article.split(",");
            for(int q=0; q<articleProps.length; q++){
                articleProps[q] = articleProps[q].trim();
            }
            Article art = new Article(articleProps[0], articleProps[1], articleProps[2]);
            list.add(art);
        }
        String sortBy = scanner.nextLine();

        switch(sortBy){
            case "title":
                list = list = list.stream().sorted((object1, object2) -> object1.getTitle().compareTo(object2.getTitle())).collect(Collectors.toCollection(ArrayList<Article>::new));
                break;
            case "content":
                list = list = list.stream().sorted((object1, object2) -> object1.getContent().compareTo(object2.getContent())).collect(Collectors.toCollection(ArrayList<Article>::new));
                break;
            case "author":
                list = list = list.stream().sorted((object1, object2) -> object1.getAuthor().compareTo(object2.getAuthor())).collect(Collectors.toCollection(ArrayList<Article>::new));
                break;
        }
        for(Article art: list) {
            System.out.println(art);
        }
    }
}


