        +---------+
        | ISSUED  |
        +----+----+
             |                     +----+------+
             | chancelTicket() --->| CANCELLED |
             |                     +----+------+
             | payTicket()
             v
        +----+----+
        |   PAID  |
        +----+----+
             | validateTicket()
             v
        +----+----+
        | VALIDATED|
        +----+----+
             | closeTicket()
             v
        +----+----+
        |  CLOSED |
        +---------+
