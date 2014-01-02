package mytnyk.gts.kernel;

public enum StrategyType {
	CHAOTIC(ChaoticStrategy.class, "Chaotic"), //$NON-NLS-1$
	MANUAL (ManualStrategy .class, "Manual" ), //$NON-NLS-1$
	STATIC (StaticStrategy .class, "Static" ); //$NON-NLS-1$

	final private Class<? extends IStrategy> mClass;
	final private String mStrategyName;
	private StrategyType(Class<? extends IStrategy> c, String strategyName) {
		mClass = c;
		mStrategyName = strategyName;
	}
	
    static private IStrategy create(StrategyType type) {
		try {
			return type.mClass.newInstance();
		} catch (Exception e) {
			throw new IllegalArgumentException("Constructor must be default!", e); //$NON-NLS-1$
		}
    }
    
    public static IStrategy create(String strategyName){
        for (StrategyType type : StrategyType.values()) {
            if (type.mStrategyName.equalsIgnoreCase(strategyName))
                return create(type);
        }
        throw new RuntimeException("Unknown strategy!"); //$NON-NLS-1$
    }
}
