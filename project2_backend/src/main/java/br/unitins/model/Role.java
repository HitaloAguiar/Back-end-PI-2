package br.unitins.model;

public enum Role {
    
    ADMIN(1, "Admin"),
    USER_EMPLOYEE(2, "Funcionario"),
    USER_CLIENT(3, "Cliente");
    
    private int id;
    private String label;

    Role (int id, String label) {

        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static Role valueOf (Integer id) throws IllegalArgumentException {

        if (id == null)
            return null;

        for (Role role : Role.values()) {
            
            if (id == role.id)
                return role;
        }

        throw new IllegalArgumentException("Papel não existe");
    }

}
