using Microsoft.AspNetCore.Mvc;
using sante.Service;
using System.Collections.Generic;
using sante.Models;

namespace Sante_Module.Controllers;

[ApiController]
[Route("[controller]/[action]")]
public class WeatherForecastController : ControllerBase
{
    private static readonly string[] Summaries = new[]
    {
        "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
    };

    private readonly ILogger<WeatherForecastController> _logger;

    public WeatherForecastController(ILogger<WeatherForecastController> logger)
    {
        _logger = logger;
    }

    [HttpGet(Name = "GetWeatherForecast")]
    public IEnumerable<WeatherForecast> Get()
    {
        return Enumerable.Range(1, 5).Select(index => new WeatherForecast
        {
            Date = DateOnly.FromDateTime(DateTime.Now.AddDays(index)),
            TemperatureC = Random.Shared.Next(-20, 55),
            Summary = Summaries[Random.Shared.Next(Summaries.Length)]
        })
        .ToArray();
    }

    [HttpGet(Name = "GetPersonnes")]
    public Personne[] GetPersonnes(){
        PersonneService p = new PersonneService();
        Personne[] ps = p.GetPersonnes();
        // Api test call
        p.TestCallAPIUrl();
        return ps;
    }

    [HttpGet(Name = "GetPersonne/{id}")]
    public Personne GetPersonne(string id){
        PersonneService p = new PersonneService();
        Personne personne = p.GetPersonne(id);
        return personne;
    }


}
