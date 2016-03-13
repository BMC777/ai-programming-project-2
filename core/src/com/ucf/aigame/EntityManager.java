package com.ucf.aigame;

import com.ucf.aigame.component.Component;

import java.util.*;

/**
 * <h1>EntityManager</h1>
 * The EntityManager class manages the List globalEntityList containing Integers representing
 * Entities.
 *
 * @author Bryan Casey
 * @version 0.1.0
 * @since 0.1.0
 */

/**
 * TODO: Create an Aspects class and change all Class<A> objects to Aspect objects.
 * TODO: Possibly create a ComponentManager class to further separate Entities and Components.
 */
public final class EntityManager
{

    private static int nextEntityID = 1;

    List<Integer> globalEntityIDList;
    List<Integer> freeEntityIDList;
    HashMap<Class<?>, HashMap<Integer, ? extends Component>> componentTypeMap;

    public EntityManager()
    {
        globalEntityIDList = new LinkedList<Integer>();
        freeEntityIDList = new LinkedList<Integer>();

        componentTypeMap = new HashMap<Class<?>, HashMap<Integer, ? extends Component>>();
    }

    public int createEntity()
    {
        int nextEntityID = generateNextEntityID();

        globalEntityIDList.add(nextEntityID);

        return nextEntityID;
    }

    public void destroyEntity( Integer entity )
    {
        globalEntityIDList.remove(entity);

        for ( HashMap<Integer, ? extends Component> entityMap : componentTypeMap.values() )
        {
            entityMap.remove(entity);
        }
    }

    public <T extends Component> void addComponent( int entity, T newComponent )
    {
        //Get the map containing the entities with type T components
        HashMap<Integer, ? extends Component> entityMap = componentTypeMap.get( newComponent.getClass() );

        //If no such map already exists, create a new map.
        if ( entityMap == null )
        {
            entityMap = new HashMap<Integer, T>();
            componentTypeMap.put( newComponent.getClass(), entityMap );
        }

        //Cast the map's Component values to the specific componentType, then map the new Component to the given Entity.
        ((HashMap<Integer, T>)entityMap).put(entity, newComponent);
    }

    public <T extends Component> T getComponent( int entityID, Class<T> componentType )
    {
        //Get the map containing the entities with components of Type T.
        HashMap<Integer, ? extends Component> entityMap = componentTypeMap.get( componentType );

        //Get the component, and cast it to it's specific type.
        T foundComponent = componentType.cast(entityMap.get(entityID));

        return foundComponent;
    }

    //Return Set because no Entity will be a duplicate.
    public <T extends Component> Set<Integer> getEntitiesWithComponentsOfType( Class<T> componentType )
    {
        //Get the map containing the entities with type T components
        HashMap<Integer, ? extends Component> entityMap = componentTypeMap.get( componentType );

        //If no such map already exists, return an empty map.
        if ( entityMap == null )
        {
            return new HashSet<Integer>();
        }

        return entityMap.keySet();
    }

    public <T extends Component> List<T> getComponentsOfType( Class<T> componentType )
    {
        //Get the map containing the entities with type T components
        HashMap<Integer, ? extends Component> entityMap = componentTypeMap.get( componentType );

        //If no such map already exists, return an empty LinkedList.
        if ( entityMap == null )
        {
            return new LinkedList<T>();
        }
        else
        {
            //Create an ArrayList from the found Components and return the new ArrayList.
            List<T> componentList = new ArrayList<T>((java.util.Collection<T>)entityMap.values());
            return componentList;
        }
    }

    private int generateNextEntityID()
    {
        if (!freeEntityIDList.isEmpty())
        {
            Integer newID = freeEntityIDList.remove(0);
        }
        //Possibly needs synchronization to prevent creation of same ID at the same time.
        return nextEntityID++;
    }
}
