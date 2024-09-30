
# Cinemille

Cinemille è un'applicazione per la gestione di un cinema, che permette agli utenti di visualizzare i film in programmazione, accedere allo storico delle programmazioni e autenticarsi tramite JWT (JSON Web Tokens).

## Funzionalità Principali

1. **Visualizzazione della Lista dei Film (RF1)**:
   Gli utenti possono visualizzare la lista dei film attualmente in programmazione.

2. **Visualizzazione dello Storico delle Programmazioni (RF2)**:
   Gli utenti possono visualizzare lo storico delle programmazioni per un determinato intervallo di date.

3. **Autenticazione con JWT (RF3)**:
   L'applicazione utilizza JWT per l'autenticazione degli utenti, permettendo l'accesso agli endpoint protetti.

## Architettura del Sistema

### Diagramma UML delle Classi

![umldi cinemille](https://github.com/user-attachments/assets/90863a99-add8-4e08-a1a4-e8d67a966cbf)


### Diagramma dei Casi d'Uso
```
[Utente] ---> (Visualizza Lista Film)
[Utente] ---> (Visualizza Storico Programmazioni)
[Utente] ---> (Effettua Login)
```

### Struttura dei Pacchetti

- **controller**: Gestisce le richieste HTTP.
- **service**: Contiene la logica di business.
- **repository**: Gestisce l'interazione con il database.
- **model**: Contiene le entità JPA.
- **dto**: Oggetti per il trasferimento dei dati.
- **security**: Contiene la logica di autenticazione e sicurezza tramite JWT.

## Tecnologie Utilizzate

- **Spring Boot**: Framework per lo sviluppo rapido di applicazioni Java.
- **Spring Security**: Per la gestione dell'autenticazione e dell'autorizzazione.
- **JWT (JSON Web Tokens)**: Per l'autenticazione stateless.
- **Hibernate/JPA**: Per la gestione delle entità e l'interazione con il database.
- **PostgreSQL**: Database relazionale utilizzato per la persistenza.

## Come Avviare il Progetto

1. **Clonare il Repository**:
   ```
   git clone https://github.com/your-username/cinemille.git
   cd cinemille
   ```

2. **Configurare il Database**:
   Configura PostgreSQL e assicurati di aggiornare il file `application.properties` o `application.yml` con le credenziali del database.

3. **Compilare ed Eseguire il Progetto**:
   ```
   mvn clean install
   mvn spring-boot:run
   ```

4. **Endpoint Disponibili**:
    - `POST /api/auth/register`: Registrazione di un nuovo utente.
    - `POST /api/auth/login`: Effettua il login e ottieni un token JWT.
    - `GET /api/movies`: Recupera la lista dei film in programmazione (protetto).
    - `GET /api/schedules`: Recupera lo storico delle programmazioni (protetto).

## Esempi di cURL per Testare l'Applicazione

### Registrazione di un Nuovo Utente
```bash
curl -X POST http://localhost:8080/api/auth/register \
    -H "Content-Type: application/json" \
    -d '{
          "username": "new_user",
          "password": "new_password",
          "role": "USER"
        }'
```

### Login e Ottenimento di un Token JWT
```bash
curl -X POST http://localhost:8080/api/auth/login \
    -H "Content-Type: application/json" \
    -d '{
          "username": "new_user",
          "password": "new_password"
        }'
```

### Accesso a un Endpoint Protetto
```bash
curl -X GET http://localhost:8080/api/movies \
    -H "Authorization: Bearer <token>"
```

### Visualizzazione dello Storico delle Programmazioni
```bash
curl -X GET http://localhost:8080/api/schedules?start=2024-01-01&end=2024-12-31 \
    -H "Authorization: Bearer <token>"
```

## **Daniele Giovane**
