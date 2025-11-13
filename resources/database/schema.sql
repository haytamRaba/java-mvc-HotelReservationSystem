-- Users table (base table for Client and Staff)
CREATE TABLE IF NOT EXISTS users (
                                     id INTEGER PRIMARY KEY AUTOINCREMENT,
                                     username TEXT UNIQUE NOT NULL,
                                     password_hash TEXT NOT NULL,
                                     email TEXT UNIQUE NOT NULL,
                                     role TEXT NOT NULL CHECK(role IN ('CLIENT', 'STAFF', 'GUEST')),
    phone TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
    );

-- Rooms table
CREATE TABLE IF NOT EXISTS rooms (
                                     id INTEGER PRIMARY KEY AUTOINCREMENT,
                                     room_number TEXT UNIQUE NOT NULL,
                                     type TEXT NOT NULL,
                                     price_per_night REAL NOT NULL,
                                     capacity INTEGER NOT NULL,
                                     description TEXT,
                                     status TEXT DEFAULT 'AVAILABLE' CHECK(status IN ('AVAILABLE', 'OCCUPIED', 'MAINTENANCE'))
    );

-- Reservations table
CREATE TABLE IF NOT EXISTS reservations (
                                            id INTEGER PRIMARY KEY AUTOINCREMENT,
                                            client_id INTEGER NOT NULL,
                                            room_id INTEGER NOT NULL,
                                            check_in_date DATE NOT NULL,
                                            check_out_date DATE NOT NULL,
                                            status TEXT DEFAULT 'PENDING' CHECK(status IN ('PENDING', 'APPROVED', 'DECLINED', 'ON_HOLD')),
    total_price REAL NOT NULL,
    comments TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (client_id) REFERENCES users(id),
    FOREIGN KEY (room_id) REFERENCES rooms(id)
    );

-- Insert sample rooms
INSERT INTO rooms (room_number, type, price_per_night, capacity, description, status) VALUES
                                                                                          ('101', 'Single', 50.00, 1, 'Cozy single room with garden view', 'AVAILABLE'),
                                                                                          ('102', 'Double', 80.00, 2, 'Spacious double room with city view', 'AVAILABLE'),
                                                                                          ('103', 'Suite', 150.00, 4, 'Luxury suite with balcony and sea view', 'AVAILABLE'),
                                                                                          ('201', 'Single', 50.00, 1, 'Single room on second floor', 'AVAILABLE'),
                                                                                          ('202', 'Double', 80.00, 2, 'Double room with king-size bed', 'AVAILABLE');

-- Insert sample staff member (password: "staff123")
INSERT INTO users (username, password_hash, email, role, phone) VALUES
    ('admin', 'staff123', 'admin@hotel.com', 'STAFF', '1234567890');