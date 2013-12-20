package ua.kiev.mytnyk.garrettheshadow;

public enum ObjectType {
	HUMAN(Human.class, ObjectCode.HUMAN),
    KEY  (Key  .class, ObjectCode.KEY);

    final private Class<? extends Object> mClass;
    final private ObjectCode mCode;
    private ObjectType(Class<? extends Object> c, ObjectCode code) {
    	mClass = c;
    	mCode = code;
    }
    
    static private Object createObject(ObjectType obj) {
		try {
			return obj.mClass.getDeclaredConstructor(ObjectType.class).newInstance(obj);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Constructor must be with ObjectFactory parameter only!");
		}
    }
    
    public static Object createObject(int code){
        for (ObjectType obj : ObjectType.values()) {
            if (obj.mCode.getCode() == code)
                return createObject(obj);
        }
        return null;
    }
}

