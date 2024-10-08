# Ubiquitous language

### General terms
- **Conference Organization Master** is the name of application.
- **System** is **Conference Organization Master** application in general.
- **Record** is data about an entity stored in a system.

### Conference
- **Conference** is an event at which there is a group of **talks** on a particular **subject**.
- **Conference detail** includes **subject**, **description**, **location** and **dates**.
- **Subject** is the central theme that guides the **talks** during the **conference**.
- **Location** is the place where the **conference** is taking place.
- **Conference status** can be:
  - **Blank** - **conference detail** is not ready yet.
  - **Expected** - **conference detail** is filled and published.
  - **Active** - **conference** is taking place.
  - **Completed** - **conference** has completed.
  - **Canceled** - **conference** was canceled.

### Talk
- **Talk** is a performance in which **speakers** shares their thoughts on a particular **topic**.
- **Talk detail** includes **topics**, **description**, **starting time** and **duration**.
- **Topic** is the theme of the concrete **talk**.
- **Talk status** can be:
    - **Blank** - **talk detail** is not ready yet.
    - **Expected** - **talk detail** is filled and published.
    - **Active** - **talk** is taking place.
    - **Completed** - **talk** has completed.
    - **Canceled** - **talk** was canceled.

### User roles
- **User** is the individual or a legal entity that uses the **System**.
- **User account** is **user record** in the System.
- **Conference organizer** is a user that organizes the **conference**.
- **Speaker** is a **user** who gives a **talk**.
- **Listener** is a **user** listening to a **talk**.
- **User status** can be:
  - **Default** - default status of the **user**
  - **Blocked** - **user** has been blocked.

### Registration
- **Register a user** - create **user account**.
- **Registration request** - a request sent by a **user** to the **System** for **registration**.
- **Register a conference** - create **conference record**.\
  Accompanied by the issuance of the **organizer role** to the corresponding **user**.
- **Register a talk** - create **talk record**.\
  Accompanied by the issuance of the **speaker role** to the corresponding **user**.