# 🐬 MySQL Docker Lab – Setup & Access Guide

This guide explains how to spin up a MySQL Docker container and access the MySQL shell to practice SQL queries.

---

## 📥 Step 1: Clone the Repository

```bash
git clone mysql-lab
cd mysql-lab
```

---

## 🔐 Step 2: Make Startup Script Executable

```bash
chmod +x start-mysql.sh
```

---

## ▶️ Step 3: Run MySQL Environment

```bash
./start-mysql.sh
```

This command will:
- Start the MySQL Docker container
- Automatically create tables
- Insert sample data

---

## 🔑 Step 4: Enter MySQL Container

```bash
docker exec -it mysql-practice mysql -u dev -pdev123 practice_db
```

---

## ✅ Successful Login

After running the above command, you should see:

```text
mysql>
```

This means you are now inside the MySQL shell and ready to execute queries.

---

## 🧪 Example Query

```sql
SHOW TABLES;
```

---

## 🔄 Cleanup / Reset (Optional)

To stop and remove the container along with data:

```bash
docker-compose down -v
```

To start again:

```bash
./start-mysql.sh
```

---

Happy querying 🚀  
This setup is ideal for learning **basic to advanced MySQL concepts**.
