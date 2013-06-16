package info.archinnov.achilles.entity.metadata;

import info.archinnov.achilles.entity.metadata.util.PropertyTypeExclude;
import info.archinnov.achilles.entity.metadata.util.PropertyTypeFilter;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * PropertyType
 * 
 * @author DuyHai DOAN
 * 
 */
public enum PropertyType
{

	START_EAGER(0), //
	SERIAL_VERSION_UID(10), //
	SIMPLE(20), //
	LIST(30), //
	SET(40), //
	MAP(50), //
	END_EAGER(60), //
	LAZY_SIMPLE(70), //
	COUNTER(70), //
	LAZY_LIST(70), //
	LAZY_SET(70), //
	LAZY_MAP(70), //
	WIDE_MAP(70), //
	COUNTER_WIDE_MAP(70), //
	JOIN_SIMPLE(70), //
	JOIN_LIST(70), //
	JOIN_SET(70), //
	JOIN_MAP(70), //
	JOIN_WIDE_MAP(70), //
	COMPOUND_KEY(70);

	private final int flag;

	PropertyType(int flag) {
		this.flag = flag;
	}

	public byte[] flag()
	{
		return new byte[]
		{
			(byte) flag
		};
	}

	public boolean isLazy()
	{
		return (this == COUNTER //
				|| this == LAZY_SIMPLE //
				|| this == LAZY_LIST //
				|| this == LAZY_SET //
				|| this == LAZY_MAP //
				|| this == WIDE_MAP //
				|| this == COUNTER_WIDE_MAP //
				|| this == JOIN_SIMPLE //
				|| this == JOIN_LIST //
				|| this == JOIN_SET //
				|| this == JOIN_MAP //
		|| this == JOIN_WIDE_MAP);
	}

	public boolean isJoinColumn()
	{
		return (this == JOIN_SIMPLE //
				|| this == JOIN_LIST //
				|| this == JOIN_SET //
				|| this == JOIN_MAP //
		|| this == JOIN_WIDE_MAP);
	}

	public boolean isWideMap()
	{
		return (this == WIDE_MAP //
				|| this == COUNTER_WIDE_MAP //
		|| this == JOIN_WIDE_MAP);
	}

	public boolean isCounter()
	{
		return (this == COUNTER //
		|| this == COUNTER_WIDE_MAP);
	}

	public boolean isProxyType()
	{
		return (this == COUNTER //
				|| this == COUNTER_WIDE_MAP //
				|| this == WIDE_MAP //
		|| this == JOIN_WIDE_MAP);
	}

	public boolean isCompoundKey()
	{
		return this == COMPOUND_KEY;
	}

	public static PropertyType[] nonProxyJoinTypes()
	{
		return new PropertyType[]
		{
				JOIN_SIMPLE,
				JOIN_LIST,
				JOIN_SET,
				JOIN_MAP
		};
	}

	public static PropertyTypeFilter joinPropertyType = new PropertyTypeFilter(nonProxyJoinTypes());
	public static PropertyTypeFilter joinSimpleType = new PropertyTypeFilter(JOIN_SIMPLE);
	public static PropertyTypeFilter joinCollectionType = new PropertyTypeFilter(JOIN_LIST,
			JOIN_SET);
	public static PropertyTypeFilter joinMapType = new PropertyTypeFilter(JOIN_MAP);
	public static PropertyTypeFilter isProxyType = new PropertyTypeFilter(COUNTER,
			COUNTER_WIDE_MAP, WIDE_MAP, JOIN_WIDE_MAP);

	public static PropertyTypeExclude excludeProxyType = new PropertyTypeExclude(COUNTER,
			COUNTER_WIDE_MAP, WIDE_MAP, JOIN_WIDE_MAP);

	public static PropertyTypeFilter eagerType = new PropertyTypeFilter(SIMPLE, LIST, SET, MAP);

	public static Set<PropertyType> multiValuesNonProxyTypes = Sets.newHashSet(LIST, LAZY_LIST,
			SET, LAZY_SET, MAP, LAZY_MAP);
}
