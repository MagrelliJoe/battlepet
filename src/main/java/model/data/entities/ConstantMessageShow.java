package model.data.entities;

import java.util.Random;

public enum ConstantMessageShow {
    MESSAGGIO_1("Puoi controllare il tuo Team cliccando sulla barra spaziatrice!"),
    MESSAGGIO_2("Per vedere i Leader che hai battuto o meno,clicca il pulsante 'L'"),
    MESSAGGIO_3("Se vuoi salvare premi il pulsante 'S',non dimenticare di farlo prima di chiudere il gioco!"),
    MESSAGGIO_4("Lo sai che puoi sconfiggere un allenatore al massimo per due volte?I Leader invece solo una volta!"),
    MESSAGGIO_5("Ogni volta che raggiungi un tot numero di vittorie,la prof.ssa Alice ti donerà un Pet da aggiungere al tuo Team!"),
    MESSAGGIO_6("Se sconfiggi il Leader della città,apparirà un bollino rosso chiamato 'vortice di cambio zona'"),
    MESSAGGIO_7("Il vortice di cambio zona serve per poter proseguire alla mappa successiva!"),
    MESSAGGIO_8("Ogni Pet ha una serie di attacchi che dipendono dal tipo!"),
    MESSAGGIO_9("Ogni attacco di un Pet ha un numero limitato di utilizzi che viene ripristinato solo alla fine della lotta"),
    MESSAGGIO_10("Non ti preoccupare se il tuo Pet ha perso vita durante la battaglia,appena lo scontro termina la stessa viene ripristinata!"),
    MESSAGGIO_11("Più vittorie farai,prima salirai di livello e cosi anche i tuoi Pet!A cosa serve? A far imparare nuovi attacchi più potenti ai Pet!"),
    MESSAGGIO_12("Vale sempre la pena sconfiggere due volte un allenatore!Più vittorie si hanno,meglio è!"),
    MESSAGGIO_13("Ad Isla Nueva esistono 5 tipi di Pet: Dog,Cat,Bird,Rabbit e Turtle"),
    MESSAGGIO_14("I Pet di tipo Dog hanno attacchi più potenti degli altri Pet, ma anche caratteristiche generali inferiori!"),
    MESSAGGIO_15("I Pet di tipo Cat hanno una difesa migliore degli altri, ma anche una potenza inferiore!"),
    MESSAGGIO_16("I Pet di tipo Rabbit hanno una velocità migliore degli altri, ma anche una potenza inferiore!"),
    MESSAGGIO_17("I Pet di tipo Turtle hanno una difesa migliore degli altri, ma anche una velocità inferiore!"),
    MESSAGGIO_18("I Pet di tipo Bird hanno una potenza migliore degli altri, ma anche una difesa inferiore!"),
    MESSAGGIO_19("Alcuni attacchi non infliggono danno ma aumentano difesa o potenza!"),
    MESSAGGIO_20("Se passi il mouse sopra il nome di un attacco,ti apparirà la descrizione completa dello stesso!"),
    MESSAGGIO_21("Non tutti sono allenatori con cui poter lottare,molti ti daranno solo consigli sul gioco o altre info!"),
    MESSAGGIO_22("Per lottare con qualcuno o parlarci,cammina fino ad essere di fronte a lui!"),
    MESSAGGIO_23("Per usare il vortice di cambio zona devi solo salirci sopra!");




    private String messaggio;

    ConstantMessageShow(String messaggio) {
        this.messaggio = messaggio;
    }

    public String getMessaggio() {
        return messaggio;
    }

    public static ConstantMessageShow getMessaggioCasuale() {
        Random random = new Random();
        int indiceCasuale = random.nextInt(values().length);
        return values()[indiceCasuale];
    }
}



