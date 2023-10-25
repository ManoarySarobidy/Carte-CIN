using System.Collections.Generic;

using sante.Models;
using System.Net;

using Npgsql;


namespace sante.Service;


public class PersonneService{

	public Personne[] GetPersonnes(){
		
		List<Personne> personnes = new List<Personne>();
		Console.WriteLine( "Get Connection succeed" );
		using( NpgsqlConnection connection = Connection.GetConnection() ){
            string sql = "select * from personne";
            using(NpgsqlCommand command = new NpgsqlCommand(sql , connection)){
                using( NpgsqlDataReader reader = command.ExecuteReader() ){
                    while( reader.Read() ){
                        Personne p = new Personne();
                        p.IdPersonne = (int) reader["id_personne"];
                        p.FirstName = (string) reader["firstName"];
                        p.Cin = (string) reader["cin"];
                        p.LastName = (string) reader["lastName"];
                        p.DateNaissance = DateOnly.FromDateTime( (DateTime) reader["dateNaissance"]  );
                        p.GroupeSanguin = (string) reader["groupe"];
                        personnes.Add(p);
                    }
                }
            }
        }
		return personnes.ToArray(); 
	}

    public Personne GetPersonne(string cin){
        
        Personne personne = null;
        // Console.WriteLine( "Get Connection succeed" );
        using( NpgsqlConnection connection = Connection.GetConnection() ){
            string sql = "select * from personne where cin = '" + cin + "'";
            using(NpgsqlCommand command = new NpgsqlCommand(sql , connection)){
                using( NpgsqlDataReader reader = command.ExecuteReader() ){
                    while( reader.Read() ){
                        personne = new Personne();
                        personne.IdPersonne = (int) reader["id_personne"];
                        personne.FirstName = (string) reader["firstName"];
                        personne.Cin = (string) reader["cin"];
                        personne.LastName = (string) reader["lastName"];
                        personne.DateNaissance = DateOnly.FromDateTime( (DateTime) reader["dateNaissance"]  );
                        personne.GroupeSanguin = (string) reader["groupe"];
                        personne.SetInformation();
                    }
                }
            }
        }
        return personne;
    }

    public bool Exist( String cin ){
        Personne personne = new Personne();
        personne.Cin = cin;
        return personne.Exist();
    }

    public void TestCallAPIUrl(){
        // Andao ijery tuto
        Personne personne = new Personne();
        personne.Cin = "123456";
        // personne.SetBank();
        // personne.SetFoncier();
    }


}