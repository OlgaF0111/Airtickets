package org.example.Tickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class TicketManagerTest {

    //поиск нескольких билетов из Новосиба в Горный отсортирован от мин цены
    @Test
    public void sortTickets() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(10, "OVB", "RGK", 2135, 123);
        Ticket ticket2 = new Ticket(20, "DME", "ALA", 4569, 142);
        Ticket ticket3 = new Ticket(30, "ALA", "OVB", 5230, 147);
        Ticket ticket4 = new Ticket(40, "RGK", "KRR", 5123, 159);
        Ticket ticket5 = new Ticket(50, "OVB", "RGK", 1456, 179);
        Ticket ticket6 = new Ticket(60, "ALA", "OVB", 2456, 167);
        Ticket ticket7 = new Ticket(70, "OVB", "RGK", 3210, 199);
        Ticket ticket8 = new Ticket(80, "ALA", "OVB", 4896, 155);
        Ticket ticket9 = new Ticket(90, "KZN", "DME", 1478, 177);
        Ticket ticket10 = new Ticket(100, "OVB", "RGK", 5689, 200);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket5, ticket1, ticket7, ticket10};
        Ticket[] actual = manager.findAll("OVB", "RGK");
        Assertions.assertArrayEquals(expected, actual);
    }

    // не найдено ни одного билета по маршруту
    @Test
    public void ticketNotFound() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(10, "OVB", "RGK", 2135, 123);
        Ticket ticket2 = new Ticket(20, "DME", "ALA", 4569, 142);
        Ticket ticket3 = new Ticket(30, "ALA", "OVB", 5230, 147);
        Ticket ticket4 = new Ticket(40, "RGK", "KRR", 5123, 159);
        Ticket ticket5 = new Ticket(50, "OVB", "RGK", 1456, 179);
        Ticket ticket6 = new Ticket(60, "ALA", "OVB", 2456, 167);
        Ticket ticket7 = new Ticket(70, "OVB", "RGK", 3210, 199);
        Ticket ticket8 = new Ticket(80, "ALA", "OVB", 4896, 155);
        Ticket ticket9 = new Ticket(90, "KZN", "DME", 1478, 177);
        Ticket ticket10 = new Ticket(100, "OVB", "RGK", 5689, 200);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("ALA", "RGK");
        Assertions.assertArrayEquals(expected, actual);
    }

    // найден один билет по маршруту
    @Test
    public void ticketFound() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(10, "OVB", "RGK", 2135, 123);
        Ticket ticket2 = new Ticket(20, "DME", "ALA", 4569, 142);
        Ticket ticket3 = new Ticket(30, "ALA", "OVB", 5230, 147);
        Ticket ticket4 = new Ticket(40, "RGK", "KRR", 5123, 159);
        Ticket ticket5 = new Ticket(50, "OVB", "RGK", 1456, 179);
        Ticket ticket6 = new Ticket(60, "ALA", "OVB", 2456, 167);
        Ticket ticket7 = new Ticket(70, "OVB", "RGK", 3210, 199);
        Ticket ticket8 = new Ticket(80, "ALA", "OVB", 4896, 155);
        Ticket ticket9 = new Ticket(90, "KZN", "DME", 1478, 177);
        Ticket ticket10 = new Ticket(100, "OVB", "RGK", 5689, 200);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.findAll("RGK", "KRR");
        Assertions.assertArrayEquals(expected, actual);

    }

    // удаление по ID
    @Test
    public void deletedByID() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(10, "OVB", "RGK", 2135, 123);
        Ticket ticket2 = new Ticket(20, "DME", "ALA", 4569, 142);
        Ticket ticket3 = new Ticket(30, "ALA", "OVB", 5230, 147);
        Ticket ticket4 = new Ticket(40, "RGK", "KRR", 5123, 159);
        Ticket ticket5 = new Ticket(50, "OVB", "RGK", 1456, 179);
        Ticket ticket6 = new Ticket(60, "ALA", "OVB", 2456, 167);
        Ticket ticket7 = new Ticket(70, "OVB", "RGK", 3210, 199);
        Ticket ticket8 = new Ticket(80, "ALA", "OVB", 4896, 155);
        Ticket ticket9 = new Ticket(90, "KZN", "DME", 1478, 177);
        Ticket ticket10 = new Ticket(100, "OVB", "RGK", 5689, 200);
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);
        repo.add(ticket9);
        repo.add(ticket10);
        repo.removeById(10);
        repo.removeById(30);
        repo.removeById(50);
        repo.removeById(100);

        Ticket[] expected = {ticket2, ticket4, ticket6, ticket7, ticket8, ticket9};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    // возвращаем все билеты
    @Test
    public void allTickets() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);
        Ticket ticket1 = new Ticket(10, "OVB", "RGK", 2135, 123);
        Ticket ticket2 = new Ticket(20, "DME", "ALA", 4569, 142);
        Ticket ticket3 = new Ticket(30, "ALA", "OVB", 5230, 147);
        Ticket ticket4 = new Ticket(40, "RGK", "KRR", 5123, 159);
        Ticket ticket5 = new Ticket(50, "OVB", "RGK", 1456, 179);
        Ticket ticket6 = new Ticket(60, "ALA", "OVB", 2456, 167);
        Ticket ticket7 = new Ticket(70, "OVB", "RGK", 3210, 199);
        Ticket ticket8 = new Ticket(80, "ALA", "OVB", 4896, 155);
        Ticket ticket9 = new Ticket(90, "KZN", "DME", 1478, 177);
        Ticket ticket10 = new Ticket(100, "OVB", "RGK", 5689, 200);
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        repo.add(ticket7);
        repo.add(ticket8);
        repo.add(ticket9);
        repo.add(ticket10);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8, ticket9, ticket10};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }
}
