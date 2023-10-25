using sante.Models.Dto;
using System.Net;
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Collections.Generic;

namespace sante.Service;
public class Devise{
	public DeviseDTO[] GetAllDevises(){
		string url = "http://localhost:8080/Tany_EJB_Library/rest/tany/devises/";
		Console.WriteLine("url === > " + url );
        WebRequest request = HttpWebRequest.Create(url);
        request.Method = "GET";
        using( WebResponse response = request.GetResponse( ) ){
            using( Stream responseStream =  response.GetResponseStream() ){
                StreamReader reader = new StreamReader(responseStream, System.Text.Encoding.UTF8);
                string json = reader.ReadToEnd();
                Console.WriteLine(json);
            	List<DeviseDTO> banks = JsonSerializer.Deserialize<List<DeviseDTO>>(json);
                return banks.ToArray();
            }
        }
	}

    public void Transferer( TransferDTO transfer ){
        string url = "http://localhost:80/Banque_Library/rest/banks/transferer/" + transfer.Send+"/"+transfer.Receive+"/"+transfer.Montant+"/"+transfer.IdDevise;
        Console.WriteLine("url ===== > " + url);
        WebRequest request = HttpWebRequest.Create( url );
        request.Method = "GET";
        using( WebResponse response = request.GetResponse() ){
            return;
        }

    }
}