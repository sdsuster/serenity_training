package com.ivanwidyan.module.ui;

import com.ivanwidyan.module.api.data.Pokemon;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PokemonDBPage extends PageObject {


  @FindBy(xpath = "//tr[th[contains(text(),'National')]]/td")
  WebElementFacade nationalNumber;

  @FindBy(xpath = "//tr[th[contains(text(),'Japanese')]]/td")
  WebElementFacade japanName;

  @FindBy(xpath = "//tr[th[contains(text(),'HP')]]/td")
  WebElementFacade hp;

  @FindBy(xpath = "//tr[th[contains(text(),'Height')]]/td")
  WebElementFacade height;
  @FindBy(xpath = "//tr[th[contains(text(), 'Weight')]]/td")
  WebElementFacade weight;
  @FindBy(xpath = "//div[@id='tab-basic-133']//div[@class='grid-col span-md-6 span-lg-4']//tr[2]//td[1]//a")
  List<WebElementFacade> types;



  public Pokemon fetchData(){
    Pokemon pokemon;
    pokemon = new Pokemon();
    pokemon.setName("0");
    pokemon.setJapanName(japanName.getText().replace("(", "").replace(")", ""));
    pokemon.setTypes(types.stream().map(WebElementFacade::getText).collect(Collectors.toList()));

    Pattern pattern = Pattern.compile("\\((.*?)\\)");
    Matcher matcher = pattern.matcher(height.getText());
    if (matcher.find())
    {
      pokemon.setHeight(Float.parseFloat(height.getText().split(" ")[0]));
    }
    pokemon.setWeight(Float.parseFloat(weight.getText().split(" ")[0]));
    pokemon.setNumber(Integer.parseInt(nationalNumber.getText()));
    pokemon.setHp(Integer.parseInt(hp.getText()));
    return pokemon;
  }


  public void openPage(String s) {
    openUrl(s);
  }
}