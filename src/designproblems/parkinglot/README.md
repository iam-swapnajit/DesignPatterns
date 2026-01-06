# 🅿️ Parking Lot LLD – Step-by-Step Understanding
*(Beginner-friendly, bottom-up, UML-driven explanation)*

You already know basic design patterns, so we’ll **explicitly connect Strategy, Singleton, Composition, and Inheritance** as we go.

---

## 1️⃣ Start from the SMALLEST objects (Bottom-Up Thinking)

### Ask:
> “What is the smallest real-world thing in a parking lot?”

---

## 🚗 Vehicle (Abstract class)

A `Vehicle` has:
- `size: VehicleSize`
- `licenseNumber: String`

### Why abstract?
- You never park a generic **Vehicle**
- You park **Car / Bike / Truck**

### Inheritance

Vehicle
├── Car
├── Bike
└── Truck

yaml
Copy code

### UML symbol
- △ (hollow triangle) → **Inheritance (IS-A)**

Examples:
- A **Car IS-A Vehicle**
- A **Truck IS-A Vehicle**

✔️ Correct OO modeling

---

## 📏 VehicleSize (Enum)

SMALL
MEDIUM
LARGE

markdown
Copy code

### Why enum?
- Fixed set of values
- Used everywhere:
    - Vehicle
    - ParkingSpot
    - FeeStrategy
- Avoids **magic strings**

---

## 2️⃣ ParkingSpot – where the Vehicle actually goes

## 🅿️ ParkingSpot

Attributes:
- `spotSize: VehicleSize`
- `spotId: String`
- `isOccupied: boolean`
- `parkedVehicle: Vehicle`

### Key behavior (VERY important):
- `canFitVehicle(Vehicle): boolean`
- `parkVehicle(Vehicle): void`
- `unparkVehicle(): void`
- `isAvailable(): boolean`

### 💡 Design insight
- `ParkingSpot` **owns the vehicle lifecycle**
- `ParkingLot` does **NOT** park vehicles directly
- This avoids **God-class anti-pattern**

### Relationship:
ParkingSpot ── has ──> Vehicle

markdown
Copy code

### UML:
- Solid line → **Association**

---

## 3️⃣ ParkingFloor – grouping spots logically

## 🏢 ParkingFloor

Attributes:
- `floorNumber: int`
- `spots: Map<String, ParkingSpot>`

### Why `Map<String, ParkingSpot>`?
- Fast lookup by `spotId`
- Realistic system behavior

### Responsibilities:
- `findAvailableSpot(Vehicle): Optional<ParkingSpot>`
- `addSpot(ParkingSpot)`
- `displayAvailability()`

### Relationship:
ParkingFloor ◇── ParkingSpot

markdown
Copy code

### UML symbol:
- ◇ (hollow diamond) → **Aggregation**

### 💡 Meaning:
- ParkingFloor **has** ParkingSpots
- Spots can exist independently (conceptually)

---

## 4️⃣ ParkingTicket – proof of parking

## 🎟️ ParkingTicket

Attributes:
- `ticketId: String`
- `entryTimestamp: long`
- `exitTimestamp: long`
- `spot: ParkingSpot`
- `vehicle: Vehicle`

### Why separate class?
- Entry / Exit timestamps
- Billing
- Tracking active parking

### Relationships:
ParkingTicket ──> Vehicle
ParkingTicket ──> ParkingSpot

markdown
Copy code

✔️ Ticket becomes the **single source of truth**

---

## 5️⃣ ParkingStrategy – HOW a spot is chosen
### (Strategy Pattern)

## 🔁 ParkingStrategy (Interface)

Method:
- `findSpot(List<ParkingFloor>, Vehicle): Optional<ParkingSpot>`

### Implementations:
- `NearestFirstStrategy`
- `BestFitStrategy`
- `FarthestFirstStrategy`

### UML symbol:
- `- - -▷` → **Implements Interface**

### 💡 Why Strategy Pattern?
- Parking rules change
- Business logic varies
- No `if-else` explosion

✔️ You already know this pattern — **perfect use case**

---

## 6️⃣ FeeStrategy – HOW parking fee is calculated
### (Strategy Pattern again)

## 💰 FeeStrategy (Interface)

Method:
- `calculateFee(ParkingTicket): double`

### Implementations:
- `FlatRateFeeStrategy`
- `VehicleBasedFeeStrategy`

### Example logic:
- Flat rate → same for all
- Vehicle based → depends on `VehicleSize`

### 💡 Notice:
- Parking logic ≠ Pricing logic
- Cleanly **decoupled**

---

## 7️⃣ ParkingLotSystem – the BRAIN 🧠

## 🧠 ParkingLotSystem

Attributes:
- `parkingStrategy: ParkingStrategy`
- `feeStrategy: FeeStrategy`
- `floors: List<ParkingFloor>`
- `activeTickets: Map<String, ParkingTicket>`

### Core APIs:
- `parkVehicle(Vehicle)`
- `unparkVehicle(String ticketId)`
- `addFloor(ParkingFloor)`
- `setParkingStrategy(...)`
- `setFeeStrategy(...)`

### Why this class exists?
- Orchestrator
- Coordinates everything
- **NO low-level logic inside**

✔️ Clean architecture

---

## 8️⃣ Singleton Pattern (VERY IMPORTANT)

Attributes:
- `instance: ParkingLotSystem`
- `getInstance()`

### Why Singleton?
- Only **ONE parking lot system**
- Centralized state
- Real-world constraint

✔️ Intentional and correct usage

---

## 9️⃣ ParkingLotDemo – Entry point

## 🚀 ParkingLotDemo

Method:
- `main(String[])`

### Purpose:
- Setup
- Create floors
- Add spots
- Choose strategies
- Simulate parking

💡 This class has **NO business logic**  
✔️ Only wiring — excellent separation

---

## 🔗 Connecting Everything (Mental Model)

### 🚗 When a car enters:
ParkingLotSystem.parkVehicle(vehicle)
→ parkingStrategy.findSpot(floors, vehicle)
→ ParkingFloor.findAvailableSpot()
→ ParkingSpot.parkVehicle()
→ ParkingTicket created
→ stored in activeTickets

graphql
Copy code

### 🚙 When a car exits:
ParkingLotSystem.unparkVehicle(ticketId)
→ fetch ParkingTicket
→ feeStrategy.calculateFee(ticket)
→ ParkingSpot.unparkVehicle()
→ remove from activeTickets

yaml
Copy code

---

## 📐 UML Symbols Cheat Sheet (Very Important)

| Symbol | Meaning |
|------|--------|
| △ | Inheritance (IS-A) |
| ◇ | Aggregation (HAS-A) |
| ─── | Association |
| - - -▷ | Interface implementation |
| Map / List | One-to-many |

---

## ✅ Final Takeaways
- Bottom-up thinking simplifies LLD
- Strategy pattern avoids rigid logic
- Singleton models real-world constraints
- Responsibilities are clearly separated
- UML relationships guide correct OO design