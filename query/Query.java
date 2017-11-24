package query;

interface Query {
    String defaultValue();  //default input
    String question();  //your query
    String doQuery(Database db, String input);
    String author();    //your name
}
