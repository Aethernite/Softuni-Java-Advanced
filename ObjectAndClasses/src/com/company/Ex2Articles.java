package com.company;

import java.util.Scanner;

public class Ex2Articles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String article = scanner.nextLine();
        String[] articleProps = article.split(",");
        for(int i=0; i<articleProps.length; i++){
            articleProps[i] = articleProps[i].trim();
        }

        Article art = new Article(articleProps[0],articleProps[1],articleProps[2]);
        int n = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<n; i++){
            String command = scanner.nextLine();
            if(command.contains("Edit: ")){
                command = command.replace("Edit: ", "");
                art.setContent(command);
            }
            else if(command.contains("Rename: ")){
                command = command.replace("Rename: ", "");
                art.setTitle(command);
            }
            else if(command.contains("ChangeAuthor: ")){
                command = command.replace("ChangeAuthor: ", "");
                art.setAuthor(command);
            }
        }
        System.out.println(art);
    }
}
class Article{
    String title;
    String content;
    String author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString(){
        return this.title + " - " + this.content + ": " + this.author;
    }
}