# Unified Platform for Student Repository and Career Suggestor

## Overview
The Unified Platform for Student Repository and Career Suggestor is designed to address two critical challenges faced by students:  
1. **Efficient Management of Personal Documents**: A secure repository for storing, managing, and retrieving important documents like Aadhar cards, PAN cards, and academic records.  
2. **Personalized Career Guidance**: Career suggestions based on an analysis of students' subject-wise marks to help them align their strengths with potential career paths.

This project simplifies document management and career exploration, empowering students and supporting educational institutions in their mission to nurture academic and professional success.

---

## Features
- **Student Repository**:  
  A centralized, secure digital space for students to upload, retrieve, and manage essential documents, ensuring they are always accessible and protected.  
- **Career Suggestor**:  
  An intelligent feature that analyzes academic performance and recommends career options aligned with students’ strengths.

---

## Technologies Used
- **JavaFX**: Provides a user-friendly and visually appealing interface.  
- **MySQL**: Ensures secure and reliable database management.  
- **Java**: Powers backend processes for seamless functionality.

---

## Installation and Usage
1. Clone the repository.
2. Download JavaFX SDK library and MySQL connector .jar file.

## Database Setup
1. Change the user and password in DB_Connection file according to your settings.
2. Create A MySQL database named 'project' and then create a table named users.
3. Columns:
user_id varchar(10) 
name varchar(100) 
prn varchar(10) PK 
email_id varchar(100) 
password varchar(50) 
aadhar_card mediumblob 
pancard mediumblob 
birth mediumblob 
marksheet12 mediumblob 
marksheet10 mediumblob 
bonafide mediumblob

**Note**: If using Intellij IDEA add JavaFX SDK and MySQL jar file to Module section of Project Structure.

 
