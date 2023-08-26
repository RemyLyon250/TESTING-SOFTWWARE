package com.example.demo;

import com.example.demo.model.Ticket;
import com.example.demo.service.TicketServiceInterface;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(classes = TicketManagementApplication.class)

public class TicketTest {

    @Autowired
    private TicketServiceInterface ticketServiceInterface;

    @BeforeEach

    public void testSave(){
        Ticket t = new Ticket();
        t.setTicketId(1);
        t.setPassengerName("test");
        t.setSource("Kigali");
        t.setDestination("Musanze");

        Ticket ticket = ticketServiceInterface
                .saveTicket(t);

        assertNotNull(ticket);
    }




    @Test
    public void testFindAll(){
        List<Ticket> tickets = ticketServiceInterface.findAllTickets();
        assertEquals(1,tickets.size());
    }

    @Test
    public void testFindById(){
        Ticket ticket = ticketServiceInterface.findTicketById(1);
        assertEquals("Musanze", ticket.getDestination());
    }
    @Test///negative test
    public void testFindNonExistingTicket(){
        int nonExistingTicketId = 999;

        Ticket ticket = ticketServiceInterface.findTicketById(nonExistingTicketId);

        assertNull(ticket);
    }

    @Test
    public void testUpdateDestination(){
        Ticket updateTicket = ticketServiceInterface.updateDestinationById(1,"Rubavu");
        assertEquals("Rubavu", updateTicket.getDestination());
    }


    @AfterAll
    @Test
    public void testDelete(){
        boolean isDeleted = ticketServiceInterface.deleteTicketById(1);
        Ticket ticket = ticketServiceInterface.findTicketById(1);
        assertNull(ticket);
        assertTrue(isDeleted);
    }
    @Test
    public void testDeleteNonExistingTicket(){
        int nonExistingTicketId = 999; // Assuming 999 does not exist in the system

        // The ticketServiceInterface.deleteTicketById() should handle the non-existing ticket gracefully
        boolean isDeleted = ticketServiceInterface.deleteTicketById(nonExistingTicketId);
        Ticket ticket = ticketServiceInterface.findTicketById(nonExistingTicketId);

        assertFalse(isDeleted); // Deletion of non-existing ticket should return false
        assertNull(ticket); // The ticket should still be null after trying to delete a non-existing ticket
    }


    
    @Test
    public void testFindNonExistingDestination(){
        String nonExistingDestination = "Kibuye";

        List<Ticket> tickets = ticketServiceInterface.findTicketByDestination(nonExistingDestination);

        assertTrue(tickets.isEmpty());
    }


}
