/*
* Classe de tests permettant de verifier la coherence des combats de pokemon
* Pokemon 1 > Pokemon 2 en attaque (Pokemon 1 gagne)
* Pokemon 2 > Pokemon 1 en attaque (Pokemon 2 gagne)
* Pokemon 1 = Pokemon 2 en attaque mais Pokemon 1 > Pokemon 2 en défense (gagnant Pokemon 1)
* Pokemon 1 = Pokemon 2 en attaque mais Pokemon 2 > Pokemon 1 en défense (gagnant Pokemon 2)
* Pokemon 1 = Pokemon 2 en attaque et Pokemon 1 = Pokemon 2 en défense (Pokemon 1 gagne)
* Pokemon 2 = Pokemon 1 en attaque et Pokemon 2 = Pokemon 1 en défense (Pokemon 2 gagne)
 */
package com.montaury.pokebagarre.metier;
import com.montaury.pokebagarre.fixtures.ConstructeurDePokemon;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PokemonTests {
    @Test
    void pokemon1_devrais_gagner_avec_attaque_superieur(){
        //GIVEN
        Pokemon pokemon1 = new ConstructeurDePokemon().avecAttaque(10).avecDefense(10).construire();
        Pokemon pokemon2 = new ConstructeurDePokemon().avecAttaque(8).avecDefense(10).construire();
        //WHEN
        boolean resultat = pokemon1.estVainqueurContre(pokemon2);
        //THEN
        assertThat(resultat).isTrue();
    }
    @Test
    void pokemon2_devrais_gagner_avec_attaque_superieur(){
        //GIVEN
        Pokemon pokemon1 = new ConstructeurDePokemon().avecAttaque(8).avecDefense(10).construire();
        Pokemon pokemon2 = new ConstructeurDePokemon().avecAttaque(10).avecDefense(10).construire();
        //WHEN
        boolean resultat = pokemon2.estVainqueurContre(pokemon1);
        //THEN
        assertThat(resultat).isTrue();
    }
    @Test
    void pokemon1_devrais_gagner_avec_defense_superieur(){
        //GIVEN
        Pokemon pokemon1 = new ConstructeurDePokemon().avecAttaque(10).avecDefense(15).construire();
        Pokemon pokemon2 = new ConstructeurDePokemon().avecAttaque(10).avecDefense(10).construire();
        //WHEN
        boolean resultat = pokemon1.estVainqueurContre(pokemon2);
        //THEN
        assertThat(resultat).isTrue();
    }
    @Test
    void pokemon2_devrais_gagner_avec_defense_superieur(){
        //GIVEN
        Pokemon pokemon1 = new ConstructeurDePokemon().avecAttaque(10).avecDefense(10).construire();
        Pokemon pokemon2 = new ConstructeurDePokemon().avecAttaque(10).avecDefense(15).construire();
        //WHEN
        boolean resultat = pokemon2.estVainqueurContre(pokemon1);
        //THEN
        assertThat(resultat).isTrue();
    }
    @Test
    void pokemon1_devrais_gagner_en_cas_de_egaliter(){
        //GIVEN
        Pokemon pokemon1 = new ConstructeurDePokemon().avecAttaque(10).avecDefense(10).construire();
        Pokemon pokemon2 = new ConstructeurDePokemon().avecAttaque(10).avecDefense(10).construire();
        //WHEN
        boolean resultat = pokemon1.estVainqueurContre(pokemon2);
        //THEN
        assertThat(resultat).isTrue();
    }
}