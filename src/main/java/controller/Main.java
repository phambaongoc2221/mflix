package controller;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Movie;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ConnectionString connectionString = new ConnectionString("mongodb+srv://root:Phambaongoc2221@cluster0.bdz6m.mongodb.net/sample_mflix?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase("sample_mflix");
        MongoCollection<Document> movies = database.getCollection("movies");

        List<Movie> list = new ArrayList<>();

        movies.find().limit(6).forEach(d -> System.out.printf(d.toJson()));


    }
}
