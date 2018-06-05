#!/bin/bash
echo "This is deploy.sh"

echo "Running helm install charts/magic-sauce-auth --name magic-sauce-auth --namespace jx"

helm install charts/magic-sauce-auth --name magic-sauce-auth --namespace jx



