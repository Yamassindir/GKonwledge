// src/components/CreateNodeForm.tsx
import React, { useState } from 'react';
import { useMutation } from '@apollo/client';
import { CREATE_NODE } from '../mutations';

interface KeyValuePairInput {
  key: string;
  value: string;
}

const CreateNodeForm: React.FC = () => {
  const [name, setName] = useState('');
  const [type, setType] = useState('');
  const [properties, setProperties] = useState<KeyValuePairInput[]>([{ key: '', value: '' }]);

  const [createNode, { data, loading, error }] = useMutation(CREATE_NODE);

  const handlePropertyChange = (index: number, field: 'key' | 'value', value: string) => {
    const updatedProperties = [...properties];
    updatedProperties[index][field] = value;
    setProperties(updatedProperties);
  };

  const addProperty = () => {
    setProperties([...properties, { key: '', value: '' }]);
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    try {
      await createNode({
        variables: { name, type, properties },
      });
      alert('Node created successfully!');
    } catch (err) {
      console.error('Error creating node:', err);
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label>Name: </label>
        <input type="text" value={name} onChange={(e) => setName(e.target.value)} required />
      </div>
      <div>
        <label>Type: </label>
        <input type="text" value={type} onChange={(e) => setType(e.target.value)} required />
      </div>

      <div>
        <label>Properties:</label>
        {properties.map((property, index) => (
          <div key={index}>
            <input
              type="text"
              placeholder="Key"
              value={property.key}
              onChange={(e) => handlePropertyChange(index, 'key', e.target.value)}
              required
            />
            <input
              type="text"
              placeholder="Value"
              value={property.value}
              onChange={(e) => handlePropertyChange(index, 'value', e.target.value)}
              required
            />
          </div>
        ))}
        <button type="button" onClick={addProperty}>
          Add Property
        </button>
      </div>

      <button type="submit" disabled={loading}>
        {loading ? 'Creating...' : 'Create Node'}
      </button>

      {error && <p>Error: {error.message}</p>}
      {data && <p>Node created with ID: {data.createNode.id}</p>}
    </form>
  );
};

export default CreateNodeForm;
