import { gql } from '@apollo/client';

export const CREATE_NODE = gql`
  mutation CreateNode($name: String!, $type: String!, $properties: [KeyValuePairInput!]!) {
    createNode(name: $name, type: $type, properties: $properties) {
      id
      name
      type
      properties {
        key
        value
      }
    }
  }
`;
