package com.capgemini.marzepka;
import io.javalin.Javalin;
public class Main {
    public static void main(String[] args){
        Javalin app = Javalin.create().start(8000);
        app.get("/", ctx->ctx.result("Hello world"));
    }
}
