namespace sante.Models;
using System.Collections.Generic;
using System.Text.Json;
using System.Text.Json.Serialization;
using Npgsql;

// [DataContract]
public class Sante{

	// [JsonIgnore]
	// Personne personne;

	Allergie[] allergies;

	// public Personne Personne{
	// 	get{
	// 		return this.personne;
	// 	}
	// 	set{
	// 		this.personne = value;
	// 	}
	// }

	public Allergie[] Allergies{
		get{
			return this.allergies;
		}set{
			this.allergies = value;
		}
	}


	// Maka ny allergie ana olona iray
	// public void SetAllergies(){
	// 	// Alaina ilay izy
	// 	string sql = "select * from v_allergies where cin = '" + this.Personne.Cin + "'";
	// 	List<Allergie> allergies = new List<Allergie>();
	// 	using( NpgsqlConnection connection = Connection.GetConnection() ){
	// 		using( NpgsqlCommand command = new NpgsqlCommand(sql, connection) ){
	// 			using(NpgsqlDataReader reader = command.ExecuteReader()){
	// 				while( reader.Read() ){
	// 					Allergie allergie = new Allergie(
	// 						(int) reader["id_allergie"],
	// 						(string) reader["nom"]
	// 					);
	// 					allergies.Add( allergie );
	// 				}
	// 			}
	// 		}
	// 	}
	// 	this.Allergies = allergies.ToArray();
	// }

	public void SetAllergies(string cin){
		// Alaina ilay izy
		string sql = "select * from v_allergies where cin = '" + cin + "'";
		List<Allergie> allergies = new List<Allergie>();
		using( NpgsqlConnection connection = Connection.GetConnection() ){
			using( NpgsqlCommand command = new NpgsqlCommand(sql, connection) ){
				using(NpgsqlDataReader reader = command.ExecuteReader()){
					while( reader.Read() ){
						Allergie allergie = new Allergie(
							(int) reader["id_allergie"],
							(string) reader["nom"]
						);
						allergies.Add( allergie );
					}
				}
			}
		}
		this.Allergies = allergies.ToArray();
	}

}