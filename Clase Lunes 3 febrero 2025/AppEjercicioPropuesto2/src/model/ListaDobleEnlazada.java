package model;

import java.util.LinkedList;

/**
 * Clase que representa una lista doblemente enlazada para gestionar los pedidos
 * del restaurante. Permite agregar, atender, cancelar, buscar, listar y
 * reasignar pedidos.
 *
 * @author Daniel
 */
public class ListaDobleEnlazada {

    private LinkedList<Pedido> lista;

    public ListaDobleEnlazada() {
        lista = new LinkedList<>();
    }

    // ✅ Agregar un nuevo pedido a la lista
    public void agregarPedido(Pedido pedido) {
        if (buscarPedido(pedido.getIdPedido()) == null) {
            lista.add(pedido);
        } else {
            System.out.println("⚠️  Error: Ya existe un pedido con este ID.");
        }
    }

    // ✅ Atender el primer pedido de la lista
    public Pedido atenderPedido() {
        if (!lista.isEmpty()) {
            Pedido pedido = lista.getFirst();
            if (pedido.getEstado().equals("Pendiente")) {
                pedido.setEstado("En preparación");
                return pedido;
            } else {
                System.out.println("⚠️  El primer pedido ya está en preparación o listo para servir.");
            }
        } else {
            System.out.println("⚠️  Error: La lista está vacía.");
        }
        return null;
    }

    // ✅ Marcar un pedido como "Listo para servir"
    public void marcarListo(int idPedido) {
        Pedido pedido = buscarPedido(idPedido);
        if (pedido != null && pedido.getEstado().equals("En preparación")) {
            pedido.setEstado("Listo para servir");
            System.out.println("✅ Pedido marcado como 'Listo para servir'.");
        } else {
            System.out.println("⚠️  Error: El pedido no está en preparación o no existe.");
        }
    }

    // ✅ Cancelar un pedido
    public void cancelarPedido(int idPedido) {
        Pedido pedido = buscarPedido(idPedido);
        if (pedido != null) {
            lista.remove(pedido);
            System.out.println("✅ Pedido cancelado exitosamente.");
        } else {
            System.out.println("⚠️  Error: Pedido no encontrado.");
        }
    }

    // ✅ Buscar un pedido por su ID
    public Pedido buscarPedido(int idPedido) {
        for (Pedido pedido : lista) {
            if (pedido.getIdPedido() == idPedido) {
                return pedido;
            }
        }
        return null;
    }

    // ✅ Listar los pedidos (en orden normal o inverso)
    public String listarPedidos(boolean inverso) {
        StringBuilder sb = new StringBuilder();
        if (lista.isEmpty()) {
            return "📋 No hay pedidos en la lista.";
        }

        if (inverso) {
            sb.append("📋 Pedidos en orden inverso:\n");
            for (int i = lista.size() - 1; i >= 0; i--) {
                Pedido p = lista.get(i);
                sb.append("ID: ").append(p.getIdPedido())
                        .append(", Cliente: ").append(p.getNombreCliente())
                        .append(", Mesa: ").append(p.getMesa())
                        .append(", Plato: ").append(p.getPlato())
                        .append(", Estado: ").append(p.getEstado())
                        .append("\n");
            }
        } else {
            sb.append("📋 Pedidos en orden de llegada:\n");
            for (Pedido p : lista) {
                sb.append("ID: ").append(p.getIdPedido())
                        .append(", Cliente: ").append(p.getNombreCliente())
                        .append(", Mesa: ").append(p.getMesa())
                        .append(", Plato: ").append(p.getPlato())
                        .append(", Estado: ").append(p.getEstado())
                        .append("\n");
            }
        }
        return sb.toString();
    }

    // ✅ Reasignar un pedido a otra mesa y cambiar el nombre del cliente
    public void reasignarPedido(int idPedido, String nuevoNombre, int nuevaMesa) {
        Pedido pedido = buscarPedido(idPedido);
        if (pedido != null) {
            if (pedido.getEstado().equals("Pendiente")) {
                if (nuevaMesa >= 1 && nuevaMesa <= 20) {
                    pedido.setNombreCliente(nuevoNombre);
                    pedido.setMesa(nuevaMesa);
                    System.out.println("✅ Pedido reasignado correctamente.");
                } else {
                    System.out.println("⚠️  Error: El número de mesa debe estar entre 1 y 20.");
                }
            } else {
                System.out.println("⚠️  Error: Solo se pueden reasignar pedidos en estado 'Pendiente'.");
            }
        } else {
            System.out.println("⚠️  Error: Pedido no encontrado.");
        }
    }
}
