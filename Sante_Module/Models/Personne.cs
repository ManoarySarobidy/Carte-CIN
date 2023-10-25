using System;
using System.Net;
using System.Text.Json;
using System.Text.Json.Serialization;
using sante.Models.Dto;
using Npgsql;

namespace sante.Models;

public class Personne{

	int idPersonne;
	string cin;
	string firstName;
	string lastName;
	DateOnly dateNaissance;
	string groupeSanguin;

	// BankDTO bank;
	// FoncierDTO[] fonciers;
	Sante sante;

	// public BankDTO Bank{
	// 	get{
	// 		return this.bank;
	// 	}
	// 	set{
	// 		this.bank = value;
	// 	}
	// }

	// public FoncierDTO[] Fonciers{
	// 	get{
	// 		return this.fonciers;
	// 	}set{
	// 		this.fonciers = value;
	// 	}
	// }

	public Sante Sante{
		get{
			return this.sante;
		}set{
			this.sante = value;
		}
	}

	public Personne(){}
	public Personne(string name){
		this.FirstName = name;
	}

	public int IdPersonne{
		get{

			return this.idPersonne;
		}
		set{
			this.idPersonne = value;
		}
	}

	public string Cin {
		get { return this.cin; }
		set{
			if( string.IsNullOrEmpty(value) ){
				throw new ArgumentException("Must have a CIN");
			}
			this.cin = value;
		}
	}

	public string FirstName{
		get { return this.firstName; }
		set{
			if( string.IsNullOrEmpty(value) ){
				throw new ArgumentException("Personne name is empty");
			}
			this.firstName = value;
		}
	}

	public string LastName{
		get { return this.lastName; }
		set{
			if( string.IsNullOrEmpty(value) ){
				throw new ArgumentException("Personne last name is empty");
			}
			this.lastName = value;
		}
	}

	public DateOnly DateNaissance {
		get{
			return this.dateNaissance;
		}
		set{
			this.dateNaissance = value;
		}
	}

	public string GroupeSanguin{
		get{
			return this.groupeSanguin;
		}
		set{
			if( string.IsNullOrEmpty( value ) ){
				throw new ArgumentException("Personne Groupe Sanguin");
			}
			this.groupeSanguin = value;
		}
	}

	public void SetInformation() {
		// this.SetBank();
		// this.SetFoncier();
		this.SetSante();
	}

	public void SetSante(){
		this.Sante = new Sante();
		// this.Sante.Personne = this;
		this.Sante.SetAllergies( this.Cin );
	}

	// public void SetBank(){
	// 	string url = "http://localhost:80/Banque_Library/rest/banks/getBank/" + this.Cin;
	// 	Console.WriteLine("url === > " + url );
 //        WebRequest request = HttpWebRequest.Create(url);
 //        request.Method = "GET";
 //        using( WebResponse response = request.GetResponse( ) ){
 //            using( Stream responseStream =  response.GetResponseStream() ){
 //                StreamReader reader = new StreamReader(responseStream, System.Text.Encoding.UTF8);
 //                string json = reader.ReadToEnd();
 //                Console.WriteLine(json);
 //                BankDTO banks = JsonSerializer.Deserialize<BankDTO>(json);
 //                this.Bank = banks;
 //            }
 //        }
	// }

	// public void SetFoncier(){
	// 	string url = "http://localhost:8080/Tany_EJB_Library/rest/tany/getTany/" + this.Cin;
	// 	Console.WriteLine("url === > " + url );
 //        WebRequest request = HttpWebRequest.Create(url);
 //        request.Method = "GET";
 //        using( WebResponse response = request.GetResponse( ) ){
 //            using( Stream responseStream =  response.GetResponseStream() ){
 //                StreamReader reader = new StreamReader(responseStream, System.Text.Encoding.UTF8);
 //                string json = reader.ReadToEnd();
 //                Console.WriteLine(json);
 //                FoncierDTO[] banks = JsonSerializer.Deserialize<FoncierDTO[]>(json);
 //                this.Fonciers = banks;
 //            }
 //        }	
	// }

	bool CheckCin(){
		string sql = "select * from personne where cin = '" + this.Cin + "'";
		Console.WriteLine(sql);
		using(NpgsqlConnection connection = Connection.GetConnection()){
			using( NpgsqlCommand command = new NpgsqlCommand(sql, connection) ){
				using( NpgsqlDataReader reader = command.ExecuteReader() ){
					while( reader.Read() ){
						return true;
					}
				}
			}
		}
		return false;
	}

	public bool Exist(){
		return this.CheckCin();
	}

}