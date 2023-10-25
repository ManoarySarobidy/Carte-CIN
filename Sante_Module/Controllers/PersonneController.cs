using Microsoft.AspNetCore.Mvc;
using sante.Service;
using System.Collections.Generic;
using sante.Models;
using sante.Models.Dto;

namespace Sante_Module.Controllers;

[ApiController]
[Route("[controller]/[action]")]
public class PersonneController: ControllerBase{

	[HttpGet(Name="/check/{cin}")]
	public bool Personne( String cin){
		PersonneService p = new PersonneService();
		if( p.Exist(cin) ) return true;
		throw new Exception("Le numero de cin : " + cin + " n'existe pas.");
	}

	[HttpGet(Name="/getPersonne/{cin}")]
	public Personne GetPersonne( String cin ){
		PersonneService p = new PersonneService();
		Personne personne = p.GetPersonne(cin);
        return personne;
	}

	[HttpGet]
	public DeviseDTO[] Devises(){
		Devise devise = new Devise();
		return devise.GetAllDevises();
	}

	[HttpPost]
	public void Transferer([FromBody] TransferDTO transfer ){
		Devise devise = new Devise();
		Console.WriteLine(transfer.Send);
	}

}	