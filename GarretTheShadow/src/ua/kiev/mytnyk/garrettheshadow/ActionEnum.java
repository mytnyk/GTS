package ua.kiev.mytnyk.garrettheshadow;

import java.lang.reflect.InvocationTargetException;

public enum ActionEnum {
    LOAD_DATA(ActionLoadConfig.class),
    LOAD_CONFIG(ActionLoadData.class);

    final private Class<? extends Action> clazz;
    private ActionEnum(Class<? extends Action> clazz) {
    	this.clazz = clazz;
    }
    public Class<? extends Action> getClazz() {
    	return this.clazz; 
    }
    
    /*static private Action getAction(Class<? extends Action> actionClazz) throws InstantiationException, IllegalAccessException {
        // logger + error handling
        return actionClazz.newInstance();
    }*/
    
    static public Action getAction(ActionEnum action) {

		try {
			return action.getClazz().getDeclaredConstructor(String.class).newInstance("h");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
    }
    
    static public Action test()
    {
    	return getAction(ActionEnum.LOAD_DATA);
    }
}

