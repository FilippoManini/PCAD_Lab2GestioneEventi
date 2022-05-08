# Foglio 2
## Gruppo: 404 - Group not found
- Davide Miggiano - 4840761
- Filippo Manini - 4798004
## Note
Come da specifica in questa piccola simulazione Admin e Utenti vengono impersonati rispettivamente da un thread a testa.

- L'admin crea l'evento → aspetta → aggiunge dei posti all'evento → aspetta → chiude l'evento
- L'utente prenota dei posti all'evento

Proponiamo due versioni:
- Una che utilizza le HashMap: Lab2_HashMap
- e l'altra che utilizza le ConcurrentHashMap: Lab2_ConcurrentHashMap

In entrambe abbiamo forzato la creazione iniziale degli eventi per evitare che avvenissero della prenotazioni "a vuoto".